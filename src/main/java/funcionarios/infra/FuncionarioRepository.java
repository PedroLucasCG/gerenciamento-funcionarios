package funcionarios.infra;

import funcionarios.domain.Funcionario;

public interface FuncionarioRepository {
    Funcionario salvarFuncionario(Funcionario funcionario);
}
