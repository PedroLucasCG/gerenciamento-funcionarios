package com.wakanda.gestao_funcionarios.funcionarios.application.service;

import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSalvarRequest;
import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSalvoResponse;
import com.wakanda.gestao_funcionarios.funcionarios.domain.Funcionario;
import com.wakanda.gestao_funcionarios.funcionarios.infra.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Log4j2
@RequiredArgsConstructor
@Service
public class FuncionarioApplicationService implements FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    @Override
    public FuncionarioSalvoResponse salvarFuncionario(FuncionarioSalvarRequest funcionarioSalvarRequest) {
        log.info("[inicio] FuncionarioApplicationService - salvarFuncionario");
        Funcionario funcionario = new Funcionario(funcionarioSalvarRequest);
        Funcionario funcionarioSalvo = funcionarioRepository.salvarFuncionario(funcionario)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR));

        FuncionarioSalvoResponse funcionarioSalvoResponse = new FuncionarioSalvoResponse(funcionarioSalvo);
        log.info("[finaliza] FuncionarioApplicationService - salvarFuncionario");
        return funcionarioSalvoResponse;
    }
}
