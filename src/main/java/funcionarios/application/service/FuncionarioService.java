package funcionarios.application.service;

import funcionarios.application.api.FuncionarioSalvarRequest;
import funcionarios.application.api.FuncionarioSalvoResponse;

public interface FuncionarioService {

    FuncionarioSalvoResponse salvarFuncionario(FuncionarioSalvarRequest funcionarioSalvarRequest);
}
