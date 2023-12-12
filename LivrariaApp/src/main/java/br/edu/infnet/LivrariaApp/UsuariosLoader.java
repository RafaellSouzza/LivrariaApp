package br.edu.infnet.LivrariaApp;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.LivrariaApp.modal.service.UsuarioService;
import br.edu.infnet.LivrariaApp.model.domain.Usuario;

@Component
public class UsuariosLoader implements ApplicationRunner {

	
	@Autowired
	private UsuarioService usuarioService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/Usuarios.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos;

        while (linha != null) {

            campos = linha.split(";");

            Usuario usuario = new Usuario();
            usuario.setId(Long.parseLong(campos[0]));
            usuario.setNome(campos[1]);
            usuario.setEmail(campos[2]);
            usuario.setSenha(campos[3]);

            usuarioService.incluir(usuario);

            linha = leitura.readLine();
        }

        for (Usuario usuario : usuarioService.obterLista()) {
            System.out.println("[Usuario]" + usuario);
        }

        leitura.close();
    }
}
