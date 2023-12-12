package br.edu.infnet.LivrariaApp.model.domain;

public class Livro {

    private Long id;
    private String titulo;
    private String autor;
    private String genero;
    private double preco;
    private String isbn;
    private String capa; 
    private String descricao;
    
    public Livro() {
    }

    public Livro(Long id, String titulo, String autor, String genero, double preco, String isbn, String capa, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.preco = preco;
        this.isbn = isbn;
        this.capa = capa;
        this.descricao = descricao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

