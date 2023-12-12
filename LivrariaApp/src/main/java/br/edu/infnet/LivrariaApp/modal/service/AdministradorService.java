package br.edu.infnet.LivrariaApp.modal.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.LivrariaApp.model.domain.Administrador;

@Service
public class AdministradorService {

    private Map<Long, Administrador> mapa = new HashMap<>();

    public void incluir(Administrador administrador) {
        mapa.put(administrador.getId(), administrador);
    }

    public Collection<Administrador> obterLista() {
        return mapa.values();
    }
}