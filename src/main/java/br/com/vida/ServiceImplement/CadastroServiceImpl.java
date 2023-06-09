package br.com.vida.ServiceImplement;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.vida.Service.CadastroService;
import lombok.extern.log4j.Log4j2;
import br.com.vida.Entity.Cadastro;
import br.com.vida.Repository.CadastroRepository;

@Service
@Log4j2
public class CadastroServiceImpl implements CadastroService {

	private CadastroRepository service;

	public CadastroServiceImpl(CadastroRepository service) {
		this.service = service;
	}

	@Override
	public List<Cadastro> listAll() {
		return service.findAll();
	}

	@Override
	public List<Cadastro> findByNomeContainingIgnoreCase(String nome) {
		return service.findByNomeContainingIgnoreCase(nome);
	}

	@Override
	public Optional<Cadastro> getId(Long id) {
		return service.findById(id);
	}

	@Override
	public Cadastro saveOrUpdate(Cadastro cm) {
		try {
			service.save(cm);
		} catch (Exception e) {
			log.getMessageFactory();
		}
		return null;
	}

	@Override
	public Cadastro alterar(Cadastro cad) {
		Long cadId = cad.getId_c();
		Optional<Cadastro> cadExistente = service.findById(cadId);
		if (cadExistente.isPresent()) {
			Cadastro cadastro = cadExistente.get();
			cadastro.setNome(cad.getNome());
			cadastro.setEnder(cad.getEnder());
			cadastro.setFone(cad.getFone());
			cadastro.setEmail(cad.getEmail());
			cadastro.setStatus(cad.getStatus());
			cadastro.setData(cad.getData());
			return service.save(cadastro);
		} else {
			throw new RuntimeException("Erro no metodo Alterar!");
		}
	}

	@Override
	public void delete(Long id) {
		Optional<Cadastro> cadExistente = service.findById(id);
		if (cadExistente.isPresent()) {
			service.deleteById(id);

		} else {
			throw new RuntimeException("Erro ao tentar excluir o cadastro!");
		}

	}

}
