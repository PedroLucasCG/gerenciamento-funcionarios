package com.wakanda.gestao_funcionarios.funcionarios.application.api;

import com.wakanda.gestao_funcionarios.funcionarios.domain.Designacao;
import com.wakanda.gestao_funcionarios.funcionarios.domain.Endereco;
import com.wakanda.gestao_funcionarios.funcionarios.domain.Funcionario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioSalvoResponse {
    private UUID id;
    private String nome;
    private Designacao designacao;
    private Double salario;
    private Endereco endereco;

    public FuncionarioSalvoResponse(Funcionario funcionario) {
        this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.designacao = funcionario.getDesignacao();
        this.salario = funcionario.getSalario();
        this.endereco = funcionario.getEndereco();
    }
}
