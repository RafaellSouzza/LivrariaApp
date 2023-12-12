package br.edu.infnet.LivrariaApp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.LivrariaApp.model.domain.Livro;

@Component
public class LivroLoader implements ApplicationRunner {

	private Map<Long,Livro> map = new HashMap<Long, Livro>();
    @Override
    public void run(ApplicationArguments args) throws Exception {

        FileReader file = new FileReader("files/Livros.txt");
        BufferedReader leitura = new BufferedReader(file);
        
        String linha =  leitura.readLine();
        String[] campos = null;
        
        while(linha != null) {
        	
        	
        	campos = linha.split(";");
        	
        	Livro livro = new Livro();
        	livro.setId( Long.parseLong(campos[0]));
        	livro.setTitulo(campos[1]);
        	livro.setAutor(campos[2]);
        	livro.setGenero(campos[3]);
        	livro.setPreco(Float.parseFloat(campos[4]));
        	livro.setIsbn(campos[5]);
        	livro.setCapa(campos[6]);
        	livro.setDescricao(campos[7]);
        	
        	map.put(livro.getId(), livro);
        	
        	linha = leitura.readLine();
        }
        
        for (Livro livro : map.values()) {
        	System.out.println("[Livro]" + livro);
		}
        
        leitura.close();

        
    }
}
