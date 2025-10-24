package br.com.fiap3espb.autoescola3espb.controller;

import br.com.fiap3espb.autoescola3espb.dto.DadosAtualizacaoInstrutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import br.com.fiap3espb.autoescola3espb.dto.InstrutorDTO;
import br.com.fiap3espb.autoescola3espb.dto.ListagemInstrutorDTO;
import br.com.fiap3espb.autoescola3espb.model.Instrutor;
import br.com.fiap3espb.autoescola3espb.repository.InstrutorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarInstrutor(@RequestBody @Valid InstrutorDTO dados) {
        repository.save(new Instrutor(dados));
    }

    @GetMapping
    // Page é uma lista de lista(para criar funcionalidade de páginas)
    //@PageableDefault seta o padrão(sem adicionar modificadores no enpoint) da busca do frontend
    public Page<ListagemInstrutorDTO> listarInstrutores(
            @PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(ListagemInstrutorDTO::new);
    }

    @PutMapping
    @Transactional
    public void atualizarInstrutores(@RequestBody @Valid DadosAtualizacaoInstrutor dados) {
        Instrutor instrutor = repository.getReferenceById(dados.id());
        instrutor.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarInstrutores(@PathVariable Long id) {
        Instrutor instrutor = repository.getReferenceById(id);
        instrutor.excluir();
    }
}
