package br.edu.infnet.LivrariaApp.model.domain;

public class Administrador {

    private Long id;
    private String nomeDeUsuario;
    private String senha;

    public Administrador() {
    }

    public Administrador(Long id, String nomeDeUsuario, String senha) {
        this.id = id;
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "id='" + id + '\'' +
                ", nomeDeUsuario='" + nomeDeUsuario + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
