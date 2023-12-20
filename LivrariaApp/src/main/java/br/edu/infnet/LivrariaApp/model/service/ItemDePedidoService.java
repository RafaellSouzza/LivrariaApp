package br.edu.infnet.LivrariaApp.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.LivrariaApp.model.domain.ItemDePedido;
import br.edu.infnet.LivrariaApp.model.repositories.ItemDePedidoRepository;



@Service
public class ItemDePedidoService {

	@Autowired
    private ItemDePedidoRepository itemDePedidoRepository;

    public void incluir(ItemDePedido itemDePedido) {
    	itemDePedidoRepository.save( itemDePedido);
    }

    public Collection<ItemDePedido> obterLista() {
        return  (Collection<ItemDePedido>) itemDePedidoRepository.findAll();
    }

    public Optional<ItemDePedido> buscarPorId(Integer id) {
        Optional<ItemDePedido> endereco = itemDePedidoRepository.findById(id);
        return endereco;
    }

    public void excluir(Integer id) {
    	itemDePedidoRepository.deleteById(id);
    }
}
