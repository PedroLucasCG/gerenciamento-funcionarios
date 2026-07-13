package com.wakanda.gestao_funcionarios.funcionarios.application.service;

import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSalvarRequest;
import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSalvoResponse;
import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSimpleResponse;
import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSingleResponse;

import java.util.List;
import java.util.UUID;

public interface FuncionarioService {

    FuncionarioSalvoResponse salvarFuncionario(FuncionarioSalvarRequest funcionarioSalvarRequest);

    List<FuncionarioSimpleResponse> retornarTodosFuncionarios();

    FuncionarioSingleResponse retornarFuncionario(UUID idFuncionario);
}
