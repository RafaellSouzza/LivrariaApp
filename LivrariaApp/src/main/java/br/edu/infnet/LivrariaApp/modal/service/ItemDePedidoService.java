package br.edu.infnet.LivrariaApp.modal.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.LivrariaApp.model.domain.ItemDePedido;

@Service
public class ItemDePedidoService {

    private Map<Long, ItemDePedido> mapa = new HashMap<>();

    public void incluir(ItemDePedido itemDePedido) {
        mapa.put(itemDePedido.getId(), itemDePedido);
    }

    public Collection<ItemDePedido> obterLista() {
        return mapa.values();
    }

}
