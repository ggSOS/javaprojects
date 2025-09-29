package br.com.fiap3espb.autoescola3espb.DTO;

import br.com.fiap3espb.autoescola3espb.model.Especialidade;

public record InstrutorDTO(
    String nome,
    String email,
    String cnh,
    Especialidade especialidade,
    Endereco endereco
    ) {
}
