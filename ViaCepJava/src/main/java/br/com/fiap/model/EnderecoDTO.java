package br.com.fiap.model;

public record EnderecoDTO(
    String cep,
    String logradouro,
    String complemento,
    String unidade,
    String bairro,
    String uf,
    String estado,
    String regiao,
    String ibge,
    String gia,
    String ddd,
    String siafi) {

}
