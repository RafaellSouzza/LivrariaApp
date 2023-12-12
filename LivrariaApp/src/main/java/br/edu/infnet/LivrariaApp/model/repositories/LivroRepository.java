package br.edu.infnet.LivrariaApp.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.LivrariaApp.model.domain.Livro;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Integer>{

}
