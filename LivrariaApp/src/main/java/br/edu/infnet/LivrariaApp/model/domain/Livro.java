package br.edu.infnet.LivrariaApp.model.domain;

import org.springframework.core.annotation.Order;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Order(3)
@Table(name = "tb_livro")
@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinTable(name = "item_id")
    private ItemDePedido itensDePedido;
    

	private String titulo;
    private String autor;
    private String genero;
    private double preco;
    private String isbn;
    private String capa; 
    private String descricao;
    
    public Livro() {
    }

    public Livro(Integer id, String titulo, String autor, String genero, double preco, String isbn, String capa, String descricao, ItemDePedido itemDePedido) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.preco = preco;
        this.isbn = isbn;
        this.capa = capa;
        this.descricao = descricao;
        this.itensDePedido = itensDePedido;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
  
    

    public ItemDePedido getItensDePedido() {
		return itensDePedido;
	}

	public void setItensDePedido(ItemDePedido itensDePedido) {
		this.itensDePedido = itensDePedido;
	}

	@Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", genero='" + genero + '\'' +
                ", preco=" + preco +
                ", isbn='" + isbn + '\'' +
                ", capa='" + capa + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}

