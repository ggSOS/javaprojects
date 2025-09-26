package br.com.fiap3espb.autoescola3espb.model.VO;

public record Endereco(
    String logradouro,
    String numero,
    String complemento,
    String bairro,
    String cidade,
    String uf,
    String cep
    ) {
}
