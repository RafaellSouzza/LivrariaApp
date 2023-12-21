package br.edu.infnet.LivrariaApp.model.clients;

import br.edu.infnet.LivrariaApp.model.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    Endereco buscaEnderecoPorCep(@PathVariable("cep") String cep);
}
