package br.edu.infnet.LivrariaApp.modal.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.LivrariaApp.model.domain.Livro;

@Service
public class LivroService {

    private Map<Long, Livro> mapa = new HashMap<>();

    public void incluir(Livro livro) {
        mapa.put(livro.getId(), livro);
    }

    public Collection<Livro> obterLista() {
        return mapa.values();
    }
}