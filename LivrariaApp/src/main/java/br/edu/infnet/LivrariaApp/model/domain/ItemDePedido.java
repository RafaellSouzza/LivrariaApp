package br.edu.infnet.LivrariaApp.model.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "tb_item_de_pedido")
@Entity
public class ItemDePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
	@ManyToMany(fetch = FetchType.EAGER)
	 @JoinTable(
	         name = "item_pedido_livro",
	         joinColumns = @JoinColumn(name = "item_de_pedido_id"),
	         inverseJoinColumns = @JoinColumn(name = "livros_id")
	 )
	 private List<Livro> livros;
    private int quantidade;
    private float precoUnitario;

    public ItemDePedido() {
    }

    public ItemDePedido(Integer id, Pedido pedido, List<Livro> livros, int quantidade, float precoUnitario) {
        this.id = id;
        
        this.pedido = pedido;
        this.livros = livros;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public  List<Livro> getLivros() {
        return livros;
    }

    public void setLivros( List<Livro> livros) {
        this.livros = livros;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    @Override
    public String toString() {
        return "ItemDePedido{" +
                "id='" + id + '\'' +
                ", pedidoID='" + pedido + '\'' +
                ", livroID='" + livros + '\'' +
                ", quantidade=" + quantidade +
                ", precoUnitario=" + precoUnitario +
                '}';
    }
}
