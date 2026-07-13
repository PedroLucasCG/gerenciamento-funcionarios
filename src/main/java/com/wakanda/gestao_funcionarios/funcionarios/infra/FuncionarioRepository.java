package com.wakanda.gestao_funcionarios.funcionarios.infra;

import com.wakanda.gestao_funcionarios.funcionarios.domain.Funcionario;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface FuncionarioRepository {
    Optional<Funcionario> salvarFuncionario(Funcionario funcionario);
}
