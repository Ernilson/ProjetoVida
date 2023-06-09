package br.com.vida;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.vida.Entity.Cadastro;
import br.com.vida.Service.CadastroService;

@SpringBootTest
class VidaApplicationTests {
	
	@Autowired
	private CadastroService service;
	
	
	@Test
	void contextLoads() {
		var cad = new Cadastro();
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		cad.setNome("Funicionou");
		cad.setEnder("12/12");
		cad.setFone("1234567");
		cad.setEmail("teste@teste");
		cad.setStatus("Feito");
		Date data = new Date(); // Obtém a data atual
	   
	    try {
	        data = sdf.parse("01/01/2023"); // Exemplo de data a ser inserida
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    
	    cad.setData(data);
	    
	    service.saveOrUpdate(cad);
		
		//service.saveOrUpdate(cad);
	
		 List<Cadastro> listaCadastros = service.listAll();
		 //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    for (Cadastro cadastro : listaCadastros) {
		       // System.out.println("Todos: " + cadastro.toString());
		        
		        System.out.println("Data: " + sdf.format(cadastro.getData()));
		    }		
	}	

}
