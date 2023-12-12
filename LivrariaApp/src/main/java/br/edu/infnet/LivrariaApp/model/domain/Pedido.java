package br.edu.infnet.LivrariaApp.model.domain;
import java.time.LocalDateTime;

public class Pedido {

    private Long id;
    private LocalDateTime data;
    private Boolean status;
    private String usuarioID;

    public Pedido() {
    }

    public Pedido(Long id, LocalDateTime data, Boolean status, String usuarioID) {
        this.id = id;
        this.data = data;
        this.status = status;
        this.usuarioID = usuarioID;
    }

    public Long getId() {
        return id;
    }

    public void setId(long l) {
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

    public String getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(String usuarioID) {
        this.usuarioID = usuarioID;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", data=" + data +
                ", status='" + status + '\'' +
                ", usuarioID='" + usuarioID + '\'' +
                '}';
    }
}
