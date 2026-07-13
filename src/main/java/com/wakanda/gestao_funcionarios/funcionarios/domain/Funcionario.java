package com.wakanda.gestao_funcionarios.funcionarios.domain;

import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioAtualizarRequest;
import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSalvarRequest;
import lombok.*;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Funcionario {
    private UUID id;
    private String nome;
    private Designacao designacao;
    private Double salario;
    private Endereco endereco;

    public Funcionario(FuncionarioSalvarRequest  funcionarioSalvarRequest) {
        this.id = UUID.randomUUID();
        this.nome = funcionarioSalvarRequest.getNome();
        this.designacao = funcionarioSalvarRequest.getDesignacao();
        this.salario = funcionarioSalvarRequest.getSalario();
        this.endereco = new Endereco(funcionarioSalvarRequest);
    }

    public void atualizar(FuncionarioAtualizarRequest funcionarioAtualizarRequest) {
        this.nome = funcionarioAtualizarRequest.getNome();
        this.designacao = funcionarioAtualizarRequest.getDesignacao();
        this.salario = funcionarioAtualizarRequest.getSalario();
        atualizarEndereco(funcionarioAtualizarRequest);
    }

    private void atualizarEndereco(FuncionarioAtualizarRequest funcionarioAtualizarRequest) {
        if (this.endereco == null) {
            this.endereco = new Endereco(funcionarioAtualizarRequest);
            return;
        }
        this.endereco.atualizar(funcionarioAtualizarRequest);
    }
}
