package br.edu.infnet.LivrariaApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.LivrariaApp.modal.service.PedidoService;
import br.edu.infnet.LivrariaApp.modal.service.UsuarioService;
import br.edu.infnet.LivrariaApp.model.domain.Pedido;
import br.edu.infnet.LivrariaApp.model.domain.Usuario;

@Component
@Order(3)
public class PedidosLoader implements ApplicationRunner {

	@Autowired
	private PedidoService pedidoService;
	@Autowired
	private UsuarioService usuarioService;
	
    @Override
    public void run(ApplicationArguments args) throws Exception {

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
            
  
            pedidoService.incluir(pedido);
            
            linha = leitura.readLine();
        }
        
        for (Pedido pedido : pedidoService.obterLista()) {
            System.out.println("[Pedido]" + pedido);
        }
        
        leitura.close();
    }
}
