package br.edu.infnet.LivrariaApp;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.LivrariaApp.model.domain.Endereco;
import br.edu.infnet.LivrariaApp.model.domain.Usuario;
import br.edu.infnet.LivrariaApp.model.service.EnderecoService;
import br.edu.infnet.LivrariaApp.model.service.UsuarioService;
@Order(1)
@Component
public class UsuariosLoader implements ApplicationRunner {

	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EnderecoService enderecoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
    	
        FileReader file = new FileReader("files/Usuarios.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos;

        while (linha != null) {

            campos = linha.split(";");

            Usuario usuario = new Usuario();
            usuario.setId(Integer.valueOf(campos[0]));
            usuario.setNome(campos[1]);
            usuario.setEmail(campos[2]);
            usuario.setSenha(campos[3]);
            usuario.setCep(campos[4]);
            
            usuario.setIsAdmin(false);

            
            Endereco endereco =  enderecoService.buscaEndereco(campos[4]);
            
            usuario.setEndereco(endereco);
            
            enderecoService.Salvar(usuario.getEndereco());
            
            usuarioService.incluir(usuario);

            linha = leitura.readLine();
        }

        for (Usuario usuario : usuarioService.obterLista()) {
            System.out.println("[Usuario]" + usuario);
        }

        leitura.close();
    }
}
