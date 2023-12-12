package br.edu.infnet.LivrariaApp.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.LivrariaApp.model.domain.Livro;
import br.edu.infnet.LivrariaApp.model.domain.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer>{

}
