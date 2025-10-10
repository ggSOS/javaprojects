package br.com.fiap3espb.autoescola3espb.dto;

import br.com.fiap3espb.autoescola3espb.enums.Especialidade;
import br.com.fiap3espb.autoescola3espb.model.Instrutor;

public record ListagemInstrutorDTO(
        String nome,
        String email,
        String cnh,
        Especialidade especialidade) {
            public ListagemInstrutorDTO(Instrutor instrutor){
                this(instrutor.getNome(), instrutor.getEmail(), instrutor.getCnh(), instrutor.getEspecialidade());
            }
}
