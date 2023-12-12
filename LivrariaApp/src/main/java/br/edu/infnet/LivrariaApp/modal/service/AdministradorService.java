package br.edu.infnet.LivrariaApp.modal.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.LivrariaApp.model.domain.Administrador;
import br.edu.infnet.LivrariaApp.model.repositories.AdministradorRepository;

@Service
public class AdministradorService {

	@Autowired
    private AdministradorRepository administradorRepository;

    public void incluir(Administrador administrador) {
    	administradorRepository.save(administrador);
    }

    public Collection<Administrador> obterLista() {
        return (Collection<Administrador>) administradorRepository.findAll();
    }
}