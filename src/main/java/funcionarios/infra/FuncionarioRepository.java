package funcionarios.infra;

import funcionarios.domain.Funcionario;

import java.util.Optional;

public interface FuncionarioRepository {
    Optional<Funcionario> salvarFuncionario(Funcionario funcionario);
}
