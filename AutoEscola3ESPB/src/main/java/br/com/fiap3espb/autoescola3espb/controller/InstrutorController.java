package br.com.fiap3espb.autoescola3espb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap3espb.autoescola3espb.dto.InstrutorDTO;
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
    public void cadastrarInstrutor(@RequestBody @Valid InstrutorDTO dados){
        repository.save(new Instrutor(dados));
    }

    @GetMapping
    public void listarInstrutores(){

    }
    

    @PutMapping
    public void atualizarInstrutores(){

    }

    @DeleteMapping
    public void deletarInstrutores(){

    }
    //todo: completar
}
