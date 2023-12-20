package br.edu.infnet.LivrariaApp.model.domain;

import org.springframework.core.annotation.Order;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Order(5)
@Table(name = "tb_item_de_pedido")
@Entity
public class ItemDePedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinTable(name = "livro_id")
	 private Livro livro;
    private int quantidade;
    private float precoUnitario;

    public ItemDePedido() {
    }

    public ItemDePedido(Integer id, Pedido pedido, Livro livro, int quantidade, float precoUnitario) {
        this.id = id;
        
        this.pedido = pedido;
        this.livro = livro;
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

    public  Livro getLivros() {
        return livro;
    }

    public void setLivros( Livro livro) {
        this.livro = livro;
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
                ", livroID='" + livro + '\'' +
                ", quantidade=" + quantidade +
                ", precoUnitario=" + precoUnitario +
                '}';
    }
}
