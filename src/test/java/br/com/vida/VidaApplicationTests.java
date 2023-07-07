package br.com.vida;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import br.com.vida.Controller.CadastroController;
import br.com.vida.Entity.Cadastro;
import br.com.vida.ServiceImplement.CadastroServiceImpl;
import io.restassured.http.ContentType;

@WebMvcTest
class CadastroControllerTests {

	@Autowired
	private CadastroController cadControl;

	@MockBean
	private CadastroServiceImpl cadService;

    @BeforeEach
    void setup() {
		standaloneSetup(this.cadControl);
	}

    @Test
    void deveRetornaSucesso() {
		List<Cadastro> cad = new ArrayList<>();
		Cadastro cad1 = new Cadastro();
		cad1.setNome("teste1");
		cad1.setEnder("quadra teste");
		cad1.setEmail("teste@test4e");
		cad.add(cad1);
		//when da biblioteca Mockito
		when(cadService.listAll())
		.thenReturn(cad);
		given()
		.accept(ContentType.JSON)
		//whes da biblioteca RestAssuredMockMvc
		.when().get("/cadastros/todos")
		.then()
		.statusCode(HttpStatus.OK
				.value());
	}
	
	@Test
	public void deverRetornaSucesso() {
		Cadastro cad1 = new Cadastro();
	    cad1.setNome("teste1");
	    cad1.setEnder("quadra teste");
	    cad1.setEmail("teste@teste.com");
	    cad1.setStatus("feito");
	    
	  //when da biblioteca Mockito
	    when(cadService.getId(1L))
	    .thenReturn(Optional.of(cad1));		
		given()
		.accept(ContentType.JSON)
		//whes da biblioteca RestAssuredMockMvc
		.when()
		.get("/cadastros/{id}",1)
		.then()
		.statusCode(HttpStatus.OK
				.value());
	}
	
	//--> https://www.youtube.com/watch?v=ngbKmhXDP4A
}
