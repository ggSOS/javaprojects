package br.com.fiap3espb.autoescola3espb.dto;

import br.com.fiap3espb.autoescola3espb.enums.Especialidade;

public record InstrutorDTO(
    String nome,
    String email,
    String cnh,
    Especialidade especialidade,
    EnderecoDTO endereco
    ) {
}
