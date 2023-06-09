package br.com.vida.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vida.Entity.Cadastro;
import br.com.vida.Service.CadastroService;


@RestController
@RequestMapping("/cadastros")
public class CadastroController {

    private CadastroService cadastroService;

    @Autowired
    public CadastroController(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @GetMapping("/todos")
    public List<Cadastro> listarTodosCadastros() {
        return cadastroService.listAll();
    }

    @GetMapping("/{id}")
    public Optional<Cadastro> buscarCadastroPorId(@PathVariable Long id) {
        return cadastroService.getId(id);
    }

    @GetMapping("/buscar")//http://localhost:9090/cadastros/buscar?nome=Funcionou
    public List<Cadastro> buscarCadastroPorNome(@RequestParam String nome) {
        return cadastroService.findByNomeContainingIgnoreCase(nome);
    }

    @PostMapping("/gravar")
    public Cadastro criarCadastro(@RequestBody Cadastro cadastro) {
        return cadastroService.saveOrUpdate(cadastro);
    }

    @PutMapping("/{id}")
    public Cadastro atualizarCadastro(@PathVariable Long id, @RequestBody Cadastro cadastro) {
        cadastro.setId_c(id);
        return cadastroService.alterar(cadastro);
    }

    @DeleteMapping("/{id}")
    public void excluirCadastro(@PathVariable Long id) {
        cadastroService.delete(id);
    }
}

