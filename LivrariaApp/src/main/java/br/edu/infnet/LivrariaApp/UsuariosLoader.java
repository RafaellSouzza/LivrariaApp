package br.edu.infnet.LivrariaApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.LivrariaApp.model.domain.Usuario;

@Component
public class UsuariosLoader implements ApplicationRunner {

    private Map<Long, Usuario> map = new HashMap<Long, Usuario>();

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

            map.put(usuario.getId(), usuario);

            linha = leitura.readLine();
        }

        for (Usuario usuario : map.values()) {
            System.out.println("[Usuario]" + usuario);
        }

        leitura.close();
    }
}
