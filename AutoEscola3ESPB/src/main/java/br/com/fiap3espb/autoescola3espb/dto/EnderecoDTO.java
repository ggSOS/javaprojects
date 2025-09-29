package br.com.fiap3espb.autoescola3espb.dto;

public record EnderecoDTO(
    String logradouro,
    String numero,
    String complemento,
    String bairro,
    String cidade,
    String uf,
    String cep
    ) {
}
