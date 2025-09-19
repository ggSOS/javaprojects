package br.com.fiap3espb.autoescola3espb.model;

public record Instrutor(
    String nome,
    String email,
    String cnh,
    Especialidade especialidade,
    Endereco endereco
    ) {
}
