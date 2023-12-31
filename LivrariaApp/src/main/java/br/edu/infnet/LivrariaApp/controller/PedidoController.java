package br.edu.infnet.LivrariaApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.LivrariaApp.model.domain.Pedido;
import br.edu.infnet.LivrariaApp.model.service.PedidoService;



@RestController
@RequestMapping("/api/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/listar")
    public List<Pedido> obterLista() {
        return (List<Pedido>) pedidoService.obterLista();
    }

    @PostMapping("/incluir")
    public void incluir(@RequestBody Pedido usuario) {
    	pedidoService.incluir(usuario);
    }

    @DeleteMapping("/{id}/excluir")
    public void excluir(@PathVariable Integer id) {
    	pedidoService.excluir(id);
    }
}
