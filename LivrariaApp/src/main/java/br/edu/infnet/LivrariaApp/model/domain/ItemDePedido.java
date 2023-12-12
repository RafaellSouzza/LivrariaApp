package br.edu.infnet.LivrariaApp.model.domain;

public class ItemDePedido {

    private Long id;
    private String pedidoID;
    private String livroID;
    private int quantidade;
    private float precoUnitario;

    public ItemDePedido() {
    }

    public ItemDePedido(Long id, String pedidoID, String livroID, int quantidade, float precoUnitario) {
        this.id = id;
        this.pedidoID = pedidoID;
        this.livroID = livroID;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(String pedidoID) {
        this.pedidoID = pedidoID;
    }

    public String getLivroID() {
        return livroID;
    }

    public void setLivroID(String livroID) {
        this.livroID = livroID;
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
                ", pedidoID='" + pedidoID + '\'' +
                ", livroID='" + livroID + '\'' +
                ", quantidade=" + quantidade +
                ", precoUnitario=" + precoUnitario +
                '}';
    }
}
