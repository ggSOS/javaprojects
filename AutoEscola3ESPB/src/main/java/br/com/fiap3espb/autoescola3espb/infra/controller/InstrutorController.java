package br.com.fiap3espb.autoescola3espb.infra.controller;

import br.com.fiap3espb.autoescola3espb.domain.dto.DadosAtualizacaoInstrutor;
import br.com.fiap3espb.autoescola3espb.domain.dto.DadosDetalhamentoInstrutorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.fiap3espb.autoescola3espb.domain.dto.InstrutorDTO;
import br.com.fiap3espb.autoescola3espb.domain.dto.ListagemInstrutorDTO;
import br.com.fiap3espb.autoescola3espb.domain.model.Instrutor;
import br.com.fiap3espb.autoescola3espb.domain.repository.InstrutorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoInstrutorDTO> cadastrarInstrutor(
            @RequestBody @Valid InstrutorDTO dados,
            UriComponentsBuilder uriBuilder) {
        Instrutor instrutor = new Instrutor(dados);
        repository.save(instrutor);
        URI uri = uriBuilder.path("/instrutores/{id").buildAndExpand(instrutor.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoInstrutorDTO(instrutor));
    }

    @GetMapping
    // Page é uma lista de lista(para criar funcionalidade de páginas)
    //@PageableDefault seta o padrão(sem adicionar modificadores no enpoint) da busca do frontend
    public ResponseEntity<Page<ListagemInstrutorDTO>> listarInstrutores(
            @PageableDefault(size = 10, sort = { "nome" }) Pageable paginacao) {
        Page page = repository.findAllByAtivoTrue(paginacao).map(ListagemInstrutorDTO::new);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoInstrutorDTO> detalharInstrutor(@PathVariable Long id){
        Instrutor instrutor = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoInstrutorDTO(instrutor));
    }


    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoInstrutorDTO> atualizarInstrutores(@RequestBody @Valid DadosAtualizacaoInstrutor dados) {
        Instrutor instrutor = repository.getReferenceById(dados.id());
        instrutor.atualizarInformacoes(dados);
        // Criar outro DTO para filtrar dados de saida caso necessario
        return ResponseEntity.ok(new DadosDetalhamentoInstrutorDTO(instrutor));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoInstrutorDTO> deletarInstrutores(@PathVariable Long id) {
        Instrutor instrutor = repository.getReferenceById(id);
        instrutor.excluir();
        // Padrao de mercado
        // public ResponseEntity<Void> deletarInstrutores(){}
        // return ResponseEntity.noContent().build();
        //
        // Versao mais completa/util
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(new DadosDetalhamentoInstrutorDTO(instrutor));
    }
}
