package br.edu.infnet.LivrariaApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.infnet.LivrariaApp.model.domain.Usuario;
import br.edu.infnet.LivrariaApp.model.service.UsuarioService;



@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public List<Usuario> obterLista() {
        return (List<Usuario>) usuarioService.obterLista();
    }

    @PostMapping("/incluir")
    public void incluir(@RequestBody Usuario usuario) {
    	usuarioService.incluir(usuario);
    }

    @DeleteMapping("/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
    	usuarioService.excluir(id);
    }
}
