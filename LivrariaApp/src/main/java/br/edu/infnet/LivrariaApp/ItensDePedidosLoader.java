package br.edu.infnet.LivrariaApp;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.LivrariaApp.modal.service.ItemDePedidoService;
import br.edu.infnet.LivrariaApp.model.domain.ItemDePedido;

@Component
public class ItensDePedidosLoader implements ApplicationRunner {

	
	@Autowired
	private ItemDePedidoService itemDePedidoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/ItensDePedidos.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos;

        while (linha != null) {

            campos = linha.split(";");

            ItemDePedido itemDePedido = new ItemDePedido();
            itemDePedido.setPedidoID(campos[0]);
            itemDePedido.setLivroID(campos[1]);
            itemDePedido.setQuantidade(Integer.parseInt(campos[2]));
            itemDePedido.setPrecoUnitario(Float.parseFloat(campos[3]));

            itemDePedidoService.incluir(itemDePedido);

            linha = leitura.readLine();
        }

        for (ItemDePedido item :itemDePedidoService.obterLista()) {
            System.out.println("[ItemDePedido]" + item);
        }

        leitura.close();
    }
}
