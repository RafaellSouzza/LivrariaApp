package br.edu.infnet.LivrariaApp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.LivrariaApp.model.clients.IBuscarEndereco;
import br.edu.infnet.LivrariaApp.model.domain.Endereco;


@Service
public class EnderecoService {

	@Autowired
	private IBuscarEndereco buscarEndereco;
	

	public Endereco buscarCep(String cep) {
		return buscarEndereco.findAddressByCep(cep);
	}
	
}