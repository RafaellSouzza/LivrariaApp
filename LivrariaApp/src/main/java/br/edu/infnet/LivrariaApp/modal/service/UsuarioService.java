package br.edu.infnet.LivrariaApp.modal.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.LivrariaApp.model.domain.Usuario;

@Service
public class UsuarioService {

    private Map<Long, Usuario> mapa = new HashMap<>();

    public void incluir(Usuario usuario) {
        mapa.put(usuario.getId(), usuario);
    }

    public Collection<Usuario> obterLista() {
        return mapa.values();
    }
}
