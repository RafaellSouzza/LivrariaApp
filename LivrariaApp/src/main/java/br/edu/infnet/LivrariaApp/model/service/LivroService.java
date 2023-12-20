package br.edu.infnet.LivrariaApp.model.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.LivrariaApp.model.domain.Endereco;
import br.edu.infnet.LivrariaApp.model.domain.Livro;
import br.edu.infnet.LivrariaApp.model.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
    private LivroRepository livroRepository;

    public void incluir(Livro livro) {
    	livroRepository.save(livro);
    }

    public Collection<Livro> obterLista() {
    	return (Collection<Livro>) livroRepository.findAll();
    }
    
    public List<Livro> obterListaPorID(String[] strings) {
    	
    	Collection<Livro> livros = new ArrayList<>();
    	for (String id : strings) {
    		Integer idInt = Integer.valueOf(id);
    		Livro livro = livroRepository.findById(idInt).get();
    		if(!livro.equals(null)) {
    			
    		livros.add(livro);
    		}
		} 
    	return  (List<Livro>) livros;
    }
    
    public Optional<Livro> buscarPorId(Integer id) {
        Optional<Livro> endereco = livroRepository.findById(id);
        return endereco;
    }

    public void excluir(Integer id) {
    	livroRepository.deleteById(id);
    }
}