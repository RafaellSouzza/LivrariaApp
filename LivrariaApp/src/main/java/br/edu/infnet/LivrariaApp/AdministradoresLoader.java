package br.edu.infnet.LivrariaApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.LivrariaApp.model.domain.Administrador;

@Component
public class AdministradoresLoader implements ApplicationRunner {

    private Map<Long, Administrador> map = new HashMap<Long, Administrador>();

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/Administradores.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos;

        while (linha != null) {

            campos = linha.split(";");

            Administrador administrador = new Administrador();
            administrador.setId(Long.parseLong(campos[0]));
            administrador.setNomeDeUsuario(campos[1]);
            administrador.setSenha(campos[2]);

            map.put(administrador.getId(), administrador);

            linha = leitura.readLine();
        }

        for (Administrador administrador : map.values()) {
            System.out.println("[Administrador]" + administrador);
        }

        leitura.close();
    }
}
