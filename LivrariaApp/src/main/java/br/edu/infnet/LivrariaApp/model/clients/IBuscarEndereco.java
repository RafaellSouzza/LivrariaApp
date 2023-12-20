package br.edu.infnet.LivrariaApp.model.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.edu.infnet.LivrariaApp.model.domain.Endereco;


@FeignClient(url = "https://viacep.com.br/ws", name = "enderecoClient")
public interface IBuscarEndereco {

    Logger logger = LoggerFactory.getLogger(IBuscarEndereco.class);

    @GetMapping(value = "/{cep}/json/")
    Endereco findAddressByCep(@PathVariable String cep);
}
