package br.edu.infnet.LivrariaApp.model.domain;

import org.springframework.core.annotation.Order;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;

@Order(2)
@MappedSuperclass
public class Administrador {

	
    private Boolean isAdmin;

    public Administrador() {
        super();
    }

    public Administrador(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

    
}
