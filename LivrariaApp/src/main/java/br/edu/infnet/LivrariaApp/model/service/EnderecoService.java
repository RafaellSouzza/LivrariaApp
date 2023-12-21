package br.edu.infnet.LivrariaApp.model.service;

import br.edu.infnet.LivrariaApp.model.clients.ViaCepClient;
import br.edu.infnet.LivrariaApp.model.domain.Endereco;
import br.edu.infnet.LivrariaApp.model.repositories.EnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EnderecoService {
	@Autowired
	private  ViaCepClient viaCepClient;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public Endereco buscaEndereco(String cep) {
		return viaCepClient.buscaEnderecoPorCep(cep);
	}
	
	public void Salvar (Endereco endereco) {
		enderecoRepository.save(endereco);
	} 
}