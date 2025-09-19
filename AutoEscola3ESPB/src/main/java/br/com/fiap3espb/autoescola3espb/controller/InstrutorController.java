package br.com.fiap3espb.autoescola3espb.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap3espb.autoescola3espb.model.Instrutor;



@RestController
@RequestMapping("/instrutores")
public class InstrutorController {
    @PostMapping
    public Instrutor cadastrarInstrutor(@RequestBody Instrutor dados){
        System.out.println(dados);
        return dados;
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
}
