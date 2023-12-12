package br.edu.infnet.LivrariaApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.LivrariaApp.model.domain.Pedido;

@Component
public class PedidosLoader implements ApplicationRunner {

	private Map<Long,Pedido> map = new HashMap<Long, Pedido>();

    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/Pedidos.txt");
        BufferedReader leitura = new BufferedReader(file);
        
        String linha = leitura.readLine();
        String[] campos;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        
        while (linha != null) {
            
            campos = linha.split(";");
            
            Pedido pedido = new Pedido();
            pedido.setId(Long.parseLong(campos[0]));
            pedido.setData(LocalDateTime.parse(campos[1], formatter));
            pedido.setStatus(campos[2]);
            pedido.setUsuarioID(campos[3]);
            
  
            map.put(pedido.getId(), pedido);
            
            linha = leitura.readLine();
        }
        
        for (Pedido pedido : map.values()) {
            System.out.println("[Pedido]" + pedido);
        }
        
        leitura.close();
    }
}
