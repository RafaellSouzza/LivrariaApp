package br.edu.infnet.LivrariaApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.LivrariaApp.modal.service.ItemDePedidoService;
import br.edu.infnet.LivrariaApp.modal.service.LivroService;
import br.edu.infnet.LivrariaApp.modal.service.PedidoService;
import br.edu.infnet.LivrariaApp.model.domain.ItemDePedido;
import br.edu.infnet.LivrariaApp.model.domain.Livro;

@Component
@Order(5)
public class ItensDePedidosLoader implements ApplicationRunner {

	
	@Autowired
	private ItemDePedidoService itemDePedidoService;
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private PedidoService pedidoService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/ItensDePedidos.txt");
        BufferedReader leitura = new BufferedReader(file);

        String linha = leitura.readLine();
        String[] campos;

        while (linha != null) {

            campos = linha.split(";");

            ItemDePedido itemDePedido = new ItemDePedido();
            
            itemDePedido.setPedido(pedidoService.obterPorId(Integer.valueOf(campos[0])));
            
            List<Livro> livros = livroService.obterListaPorID(campos[1].split(","));
            
            itemDePedido.setLivros(livros);
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
