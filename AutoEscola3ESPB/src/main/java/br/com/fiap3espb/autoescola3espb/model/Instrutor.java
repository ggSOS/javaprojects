package br.com.fiap3espb.autoescola3espb.model;

import br.com.fiap3espb.autoescola3espb.dto.InstrutorDTO;
import br.com.fiap3espb.autoescola3espb.enums.Especialidade;
import br.com.fiap3espb.autoescola3espb.vo.EnderecoVO;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "instrutores")
@Entity(name = "Instrutor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Instrutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cnh;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private EnderecoVO endereco;

    public Instrutor(InstrutorDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.cnh = dados.cnh();
        this.telefone = dados.telefone();
        this.especialidade = dados.especialidade();
        this.endereco = new EnderecoVO(dados.endereco());
    }
}
