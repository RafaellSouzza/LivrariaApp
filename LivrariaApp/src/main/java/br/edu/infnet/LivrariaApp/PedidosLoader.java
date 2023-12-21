package br.edu.infnet.LivrariaApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.LivrariaApp.model.domain.ItemDePedido;
import br.edu.infnet.LivrariaApp.model.domain.Livro;
import br.edu.infnet.LivrariaApp.model.domain.Pedido;
import br.edu.infnet.LivrariaApp.model.domain.Usuario;
import br.edu.infnet.LivrariaApp.model.service.ItemDePedidoService;
import br.edu.infnet.LivrariaApp.model.service.LivroService;
import br.edu.infnet.LivrariaApp.model.service.PedidoService;
import br.edu.infnet.LivrariaApp.model.service.UsuarioService;
@Order(3)
@Component
public class PedidosLoader implements ApplicationRunner {

	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ItemDePedidoService itemDePedidoService;
	@Autowired
	private LivroService livroService;
	
	
    @Override
    public void run(ApplicationArguments args) throws Exception {
    	
    	
    	FileReader fileItem = new FileReader("files/ItensDePedidos.txt");
        BufferedReader leituraItem = new BufferedReader(fileItem);

        String linhaItens = leituraItem.readLine();
        String[] camposItens;
        
        List<ItemDePedido> itensDePedido = new ArrayList();

        while (linhaItens != null) {

            camposItens = linhaItens.split(";");

            ItemDePedido itemDePedido = new ItemDePedido();
            
            itemDePedido.setPedido(pedidoService.obterPorId(Integer.valueOf(camposItens[0])).orElse(null));
            
            Optional<Livro> livro = livroService.buscarPorId(Integer.valueOf(camposItens[1]));
            
            itemDePedido.setLivros(livro.get());
            
            itemDePedido.setQuantidade(Integer.parseInt(camposItens[2]));
            itemDePedido.setPrecoUnitario(Float.parseFloat(camposItens[3]));
            
            itensDePedido.add(itemDePedido);
        }
    	
        FileReader file = new FileReader("files/Pedidos.txt");
        BufferedReader leitura = new BufferedReader(file);
        
        String linha = leitura.readLine();
        String[] campos;
                
        while (linha != null) {
            
            campos = linha.split(";");
            
            Pedido pedido = new Pedido();
            pedido.setId(Integer.valueOf(campos[0]));
            pedido.setData(LocalDateTime.parse(campos[1]));
            pedido.setStatus(Boolean.parseBoolean(campos[2]));
            
            Usuario usuario = usuarioService.obterUsuarioID(Integer.valueOf(campos[3]));
            pedido.setUsuario(usuario);
            List<String> listItens = new ArrayList<String>();
            String[] splitStrings = campos[6].split(",");
            listItens.addAll(Arrays.asList(splitStrings));
            
            List<ItemDePedido> itens = new ArrayList();
            
            for (ItemDePedido item : itensDePedido) {
				if(listItens.contains(item.getId())) {
					itens.add(item);
				}
			}
            
            pedido.setItensDePedido(itens);
  
            pedidoService.incluir(pedido);
            
            linha = leitura.readLine();
        }
        
        for (Pedido pedido : pedidoService.obterLista()) {
            System.out.println("[Pedido]" + pedido);
        }
        
        leitura.close();
    }
}
