package funcionarios.application.api;

import funcionarios.application.service.FuncionarioService;
import funcionarios.domain.Funcionario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class FuncionarioRestController implements FuncionarioAPI {
    private final FuncionarioService funcionarioApplicationService;

    @Override
    public FuncionarioSalvoResponse criarFuncionario(FuncionarioSalvarRequest funcionarioSalvarRequest) {
        log.info("[inicio] FuncionarioRestController - criarFuncionario");
        FuncionarioSalvoResponse funcionarioSalvoResponse
                = funcionarioApplicationService.salvarFuncionario(funcionarioSalvarRequest);
        log.info("[finaliza] FuncionarioRestController - criarFuncionario");
        return funcionarioSalvoResponse;
    }
}
