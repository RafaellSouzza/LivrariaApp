package br.edu.infnet.LivrariaApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.edu.infnet.LivrariaApp.model.domain.Livro;
import br.edu.infnet.LivrariaApp.model.service.LivroService;



@RestController
@RequestMapping("/api/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping("/listar")
    public List<Livro> obterLista() {
        return (List<Livro>) livroService.obterLista();
    }

    @PostMapping("/incluir")
    public void incluir(@RequestBody Livro livro) {
        livroService.incluir(livro);
    }

    @DeleteMapping("/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
        livroService.excluir(id);
    }
}
