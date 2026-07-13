package funcionarios.infra;

import funcionarios.domain.Funcionario;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Log4j2
public class FuncionarioRepositoryImpl implements FuncionarioRepository {
    Map<UUID, Funcionario> funcionarios = new HashMap<>();

    @Override
    public Optional<Funcionario> salvarFuncionario(Funcionario funcionario) {
        log.info("[inicio] FuncionarioRepositoryImpl - salvarFuncionario");
        funcionarios.put(funcionario.getId(), funcionario);
        log.info("[finaliza] FuncionarioRepositoryImpl - salvarFuncionario");
        return Optional.ofNullable(funcionarios.getOrDefault(funcionario.getId(), null));
    }
}
