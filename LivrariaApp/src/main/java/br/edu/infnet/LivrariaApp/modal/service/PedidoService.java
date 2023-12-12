package br.edu.infnet.LivrariaApp.modal.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.LivrariaApp.model.domain.Pedido;
import br.edu.infnet.LivrariaApp.model.repositories.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
    private PedidoRepository pedidoRepository;;

    public void incluir(Pedido pedido) {
    	pedidoRepository.save(pedido);
    }

    public Collection<Pedido> obterLista() {
        return (Collection<Pedido>) pedidoRepository.findAll();
    }
    
    public Pedido obterPorId(Integer id) {
        return pedidoRepository.findById(id).get();
    }
}
