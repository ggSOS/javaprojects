package br.com.fiap3espb.autoescola3espb.model.DTO;

import br.com.fiap3espb.autoescola3espb.model.VO.Endereco;

public record Instrutor(
    String nome,
    String email,
    String cnh,
    Especialidade especialidade,
    Endereco endereco
    ) {
}
