package br.edu.infnet.LivrariaApp;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.LivrariaApp.model.domain.Administrador;
import br.edu.infnet.LivrariaApp.model.service.AdministradorService;

@Component
@Order(4)
public class AdministradoresLoader implements ApplicationRunner {
	@Autowired
	private AdministradorService administradorService;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/Administradores.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos;

        while (linha != null) {

            campos = linha.split(";");

            Administrador administrador = new Administrador();
            administrador.setId(Integer.valueOf(campos[0]));
            administrador.setNomeDeUsuario(campos[1]);
            administrador.setSenha(campos[2]);

            administradorService.incluir(administrador);

            linha = leitura.readLine();
        }

        for (Administrador administrador : administradorService.obterLista()) {
            System.out.println("[Administrador]" + administrador);
        }

        leitura.close();
    }
}
