package com.wakanda.gestao_funcionarios.funcionarios.domain;

import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioAtualizarRequest;
import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSalvarRequest;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(FuncionarioSalvarRequest funcionarioSalvarRequest) {
        this.cep = funcionarioSalvarRequest.getCep();
        this.logradouro = funcionarioSalvarRequest.getLogradouro();
        this.complemento = funcionarioSalvarRequest.getComplemento();
        this.bairro = funcionarioSalvarRequest.getBairro();
        this.cidade = funcionarioSalvarRequest.getCidade();
        this.estado = funcionarioSalvarRequest.getEstado();
    }

    public Endereco(FuncionarioAtualizarRequest funcionarioAtualizarRequest) {
        this.cep = funcionarioAtualizarRequest.getCep();
        this.logradouro = funcionarioAtualizarRequest.getLogradouro();
        this.complemento = funcionarioAtualizarRequest.getComplemento();
        this.bairro = funcionarioAtualizarRequest.getBairro();
        this.cidade = funcionarioAtualizarRequest.getCidade();
        this.estado = funcionarioAtualizarRequest.getEstado();
    }

    public void atualizar(FuncionarioAtualizarRequest funcionarioAtualizarRequest) {
        this.cep = funcionarioAtualizarRequest.getCep();
        this.logradouro = funcionarioAtualizarRequest.getLogradouro();
        this.complemento = funcionarioAtualizarRequest.getComplemento();
        this.bairro = funcionarioAtualizarRequest.getBairro();
        this.cidade = funcionarioAtualizarRequest.getCidade();
        this.estado = funcionarioAtualizarRequest.getEstado();
    }
}
