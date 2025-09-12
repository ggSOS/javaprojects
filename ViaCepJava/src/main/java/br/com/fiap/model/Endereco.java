package br.com.fiap.model;

// INUTIL, TUDO ISSO AQUI TA NO RECORD ENDERECO, Q É DTO
public final class Endereco {
    private final String cep;
    private final String logradouro;
    private final String complemento;
    private final String unidade;
    private final String bairro;
    private final String uf;
    private final String estado;
    private final String regiao;
    private final String ibge;
    private final String gia;
    private final String ddd;
    private final String siafi; // Codigo de municipio
    

    public Endereco(String cep, String logradouro, String complemento, String unidade, String bairro, String uf,
            String estado, String regiao, String ibge, String gia, String ddd, String siafi) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.unidade = unidade;
        this.bairro = bairro;
        this.uf = uf;
        this.estado = estado;
        this.regiao = regiao;
        this.ibge = ibge;
        this.gia = gia;
        this.ddd = ddd;
        this.siafi = siafi;
    }


    public String getCep() {
        return cep;
    }


    public String getLogradouro() {
        return logradouro;
    }


    public String getComplemento() {
        return complemento;
    }


    public String getUnidade() {
        return unidade;
    }


    public String getBairro() {
        return bairro;
    }


    public String getUf() {
        return uf;
    }


    public String getEstado() {
        return estado;
    }


    public String getRegiao() {
        return regiao;
    }


    public String getIbge() {
        return ibge;
    }


    public String getGia() {
        return gia;
    }


    public String getDdd() {
        return ddd;
    }


    public String getSiafi() {
        return siafi;
    }
}
