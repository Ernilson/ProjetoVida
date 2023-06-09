package br.com.vida.Service;

import java.util.List;
import java.util.Optional;

import br.com.vida.Entity.Cadastro;

public interface CadastroService {

	List<Cadastro> listAll();

	List<Cadastro> findByNomeContainingIgnoreCase(String nome);
	
	Optional<Cadastro> getId(Long id);
	
	Cadastro saveOrUpdate(Cadastro cm);

	Cadastro alterar(Cadastro cad);		

	void delete(Long id);

}
