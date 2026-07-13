package com.wakanda.gestao_funcionarios.funcionarios.infra;

import com.wakanda.gestao_funcionarios.funcionarios.domain.Funcionario;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

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
}
