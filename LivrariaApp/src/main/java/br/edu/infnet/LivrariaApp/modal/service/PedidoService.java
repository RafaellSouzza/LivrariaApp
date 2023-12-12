package br.edu.infnet.LivrariaApp.modal.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.LivrariaApp.model.domain.Pedido;

@Service
public class PedidoService {

    private Map<Long, Pedido> mapa = new HashMap<>();

    public void incluir(Pedido pedido) {
        mapa.put(pedido.getId(), pedido);
    }

    public Collection<Pedido> obterLista() {
        return mapa.values();
    }
}
