package com.wakanda.gestao_funcionarios.funcionarios.application.service;

import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSalvarRequest;
import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSalvoResponse;
import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSimpleResponse;

import java.util.List;

public interface FuncionarioService {

    FuncionarioSalvoResponse salvarFuncionario(FuncionarioSalvarRequest funcionarioSalvarRequest);

    List<FuncionarioSimpleResponse> retornarTodosFuncionarios();
}
