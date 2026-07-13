package com.wakanda.gestao_funcionarios.funcionarios.application.api;

import com.wakanda.gestao_funcionarios.funcionarios.application.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @Override
    public List<FuncionarioSimpleResponse> recuperarTodosFuncionarios() {
        log.info("[inicio] FuncionarioRestController - criarTodosFuncionarios");
        List<FuncionarioSimpleResponse> funcionarioSimpleResponses
                = funcionarioApplicationService.retornarTodosFuncionarios();
        log.info("[finaliza] FuncionarioRestController - criarTodosFuncionarios");
        return funcionarioSimpleResponses;
    }
}
