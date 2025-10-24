package br.com.fiap3espb.autoescola3espb.dto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoInstrutor(
        @NotNull
        Long id,

        String nome,
        String telefone,
        EnderecoDTO endereco) {
}
