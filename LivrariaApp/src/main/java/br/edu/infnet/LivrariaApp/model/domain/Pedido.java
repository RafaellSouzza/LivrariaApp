package br.edu.infnet.LivrariaApp.model.domain;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Table(name = "TB_Pedido")
@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime data;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemDePedido> itensDePedido = new ArrayList<>();

    public Pedido() {
    }


	public Pedido(Integer pedido_id, LocalDateTime data, Boolean status, Usuario usuario, List<ItemDePedido> itensDePedido) {
        this.id = pedido_id;
        this.data = data;
        this.status = status;
        this.usuario = usuario;
        this.itensDePedido = itensDePedido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer l) {
        this.id = l;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
   
    public List<ItemDePedido> getItensDePedido() {
		return itensDePedido;
	}

	public void setItensDePedido(List<ItemDePedido> itensDePedido) {
		this.itensDePedido = itensDePedido;
	}

    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", data=" + data +
                ", status='" + status + '\'' +
                ", usuarioID='" + usuario + '\'' +
                '}';
    }
}
