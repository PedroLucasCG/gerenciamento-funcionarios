package com.wakanda.gestao_funcionarios.funcionarios.infra;

import com.wakanda.gestao_funcionarios.funcionarios.domain.Funcionario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface FuncionarioRepository {
    Optional<Funcionario> salvarFuncionario(Funcionario funcionario);

    List<Funcionario> todosFuncionarios();

    Optional<Funcionario> retornarFuncionarioPorId(UUID idFuncionario);
}
