package br.com.vida.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vida.Entity.Cadastro;

public interface CadastroRepository extends JpaRepository<Cadastro, Long>{

	List<Cadastro> findByNomeContainingIgnoreCase(String nome);

	 Cadastro findById(long id);
}
