package funcionarios.application.service;

import funcionarios.application.api.FuncionarioSalvarRequest;
import funcionarios.application.api.FuncionarioSalvoResponse;
import funcionarios.infra.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class FuncionarioApplicationService implements FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    @Override
    public FuncionarioSalvoResponse salvarFuncionario(FuncionarioSalvarRequest funcionarioSalvarRequest) {
        log.info("[inicio] FuncionarioApplicationService - salvarFuncionario");

        log.info("[finaliza] FuncionarioApplicationService - salvarFuncionario");
        return null;
    }
}
