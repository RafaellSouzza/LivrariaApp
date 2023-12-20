package br.edu.infnet.LivrariaApp.model.domain;

import org.springframework.core.annotation.Order;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Order(2)
@Table(name = "tb_administrador")
@Entity
public class Administrador extends Usuario{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nomeDeUsuario;
    private String senha;
    private String areaDeResponsabilidade;

    public Administrador() {
    }

    public Administrador(Integer id, String nomeDeUsuario, String senha,String areaDeResponsabilidade) {
        this.id = id;
        this.nomeDeUsuario = nomeDeUsuario;
        this.senha = senha;
        this.areaDeResponsabilidade = areaDeResponsabilidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
    
    public String getAreaDeResponsabilidade() {
        return areaDeResponsabilidade;
    }

    public void setAreaDeResponsabilidade(String areaDeResponsabilidade) {
        this.areaDeResponsabilidade = areaDeResponsabilidade;
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
