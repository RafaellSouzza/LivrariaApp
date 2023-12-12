package br.edu.infnet.LivrariaApp.model.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.LivrariaApp.model.domain.ItemDePedido;


@Repository
public interface ItemDePedidoRepository extends CrudRepository<ItemDePedido, Integer>{

}
