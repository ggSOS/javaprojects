package br.com.fiap3espb.autoescola3espb.domain.dto;

import br.com.fiap3espb.autoescola3espb.domain.enums.Especialidade;
import br.com.fiap3espb.autoescola3espb.domain.model.Instrutor;
import br.com.fiap3espb.autoescola3espb.domain.vo.EnderecoVO;

public record DadosDetalhamentoInstrutorDTO(
        Long id,
        Boolean ativo,
        String nome,
        String email,
        String telefone,
        String cnh,
        Especialidade especialidade,
        EnderecoVO endereco
) {
    public DadosDetalhamentoInstrutorDTO(Instrutor instrutor){
        this(
                instrutor.getId(),
                instrutor.getAtivo(),
                instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getTelefone(),
                instrutor.getCnh(),
                instrutor.getEspecialidade(),
                instrutor.getEndereco()
                );
    }
}
