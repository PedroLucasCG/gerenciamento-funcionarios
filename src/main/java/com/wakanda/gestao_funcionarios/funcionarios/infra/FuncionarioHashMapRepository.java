package com.wakanda.gestao_funcionarios.funcionarios.infra;

import com.wakanda.gestao_funcionarios.funcionarios.domain.Funcionario;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.*;

@Log4j2
@Repository
public class FuncionarioHashMapRepository implements FuncionarioRepository {
    Map<UUID, Funcionario> funcionarios = new HashMap<>();

    @Override
    public Optional<Funcionario> salvarFuncionario(Funcionario funcionario) {
        log.info("[inicio] FuncionarioRepositoryImpl - salvarFuncionario");
        funcionarios.put(funcionario.getId(), funcionario);
        log.info("[finaliza] FuncionarioRepositoryImpl - salvarFuncionario");
        return Optional.ofNullable(funcionarios.getOrDefault(funcionario.getId(), null));
    }

    @Override
    public List<Funcionario> todosFuncionarios() {
        log.info("[inicio] FuncionarioHashMapRepository - todosFuncionarios");
        List<Funcionario> funcionariosList = new ArrayList<>(funcionarios.values());
        log.info("[finaliza] FuncionarioHashMapRepository - todosFuncionarios");
        return funcionariosList;
    }

    @Override
    public Optional<Funcionario> retornarFuncionarioPorId(UUID idFuncionario) {
        log.info("[inicio] FuncionarioHashMapRepository - retornarFuncionarioPorId");
        Optional<Funcionario> funcionario
                = Optional.ofNullable(funcionarios.getOrDefault(idFuncionario, null));
        log.info("[finaliza] FuncionarioHashMapRepository - retornarFuncionarioPorId");
        return funcionario;
    }

    @Override
    public void deletarFuncionario(Funcionario funcionario) {
        log.info("[inicio] FuncionarioHashMapRepository - deletarFuncionario");
        funcionarios.remove(funcionario.getId());
        log.info("[finaliza] FuncionarioHashMapRepository - deletarFuncionario");
    }
}
