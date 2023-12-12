package br.edu.infnet.LivrariaApp.modal.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.LivrariaApp.model.domain.Usuario;
import br.edu.infnet.LivrariaApp.model.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
    private UsuarioRepository usuarioRepository;

    public void incluir(Usuario usuario) {
    	usuarioRepository.save(usuario);
    }

    public Collection<Usuario> obterLista() {
        return (Collection<Usuario>) usuarioRepository.findAll();
    }
    
    public Usuario obterUsuarioID(Integer id ) {
        return usuarioRepository.findById(id).get();
    }
}
