package br.edu.infnet.LivrariaApp.model.service;

import java.util.Collection;
import java.util.Optional;

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

    public Optional<Pedido> buscarPorId(Integer id) {
        Optional<Pedido> endereco = pedidoRepository.findById(id);
        return endereco;
    }

    public void excluir(Integer id) {
    	pedidoRepository.deleteById(id);
    }
}
