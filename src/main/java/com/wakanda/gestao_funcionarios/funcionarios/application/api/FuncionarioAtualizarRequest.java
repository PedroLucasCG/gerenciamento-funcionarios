package com.wakanda.gestao_funcionarios.funcionarios.application.api;

import com.wakanda.gestao_funcionarios.funcionarios.domain.Designacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuncionarioAtualizarRequest {
    private String nome;
    private Designacao designacao;
    private Double salario;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
}
