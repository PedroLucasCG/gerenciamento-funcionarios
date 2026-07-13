package com.wakanda.gestao_funcionarios.funcionarios.application.service;

import com.wakanda.gestao_funcionarios.funcionarios.application.api.*;
import com.wakanda.gestao_funcionarios.funcionarios.domain.Funcionario;

import java.util.List;
import java.util.UUID;

public interface FuncionarioService {

    FuncionarioSalvoResponse salvarFuncionario(FuncionarioSalvarRequest funcionarioSalvarRequest);

    List<FuncionarioSimpleResponse> retornarTodosFuncionarios();

    FuncionarioSingleResponse retornarFuncionario(UUID idFuncionario);

    Funcionario atualizarFuncionario(UUID idFuncionario, FuncionarioAtualizarRequest funcionarioAtualizarRequest);

    Funcionario deletarFuncionario(UUID idFuncionario);
}
