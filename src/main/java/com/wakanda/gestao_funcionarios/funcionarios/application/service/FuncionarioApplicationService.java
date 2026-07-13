package com.wakanda.gestao_funcionarios.funcionarios.application.service;

import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSalvarRequest;
import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSalvoResponse;
import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSimpleResponse;
import com.wakanda.gestao_funcionarios.funcionarios.domain.Funcionario;
import com.wakanda.gestao_funcionarios.funcionarios.infra.FuncionarioRepository;
import com.wakanda.gestao_funcionarios.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class FuncionarioApplicationService implements FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    @Override
    public FuncionarioSalvoResponse salvarFuncionario(FuncionarioSalvarRequest funcionarioSalvarRequest) {
        log.info("[inicio] FuncionarioApplicationService - salvarFuncionario");
        Funcionario funcionario = new Funcionario(funcionarioSalvarRequest);
        Funcionario funcionarioSalvo = funcionarioRepository.salvarFuncionario(funcionario).orElseThrow(
                () -> APIException.build(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao salvar funcionario"));

        FuncionarioSalvoResponse funcionarioSalvoResponse = new FuncionarioSalvoResponse(funcionarioSalvo);
        log.info("[finaliza] FuncionarioApplicationService - salvarFuncionario");
        return funcionarioSalvoResponse;
    }

    @Override
    public List<FuncionarioSimpleResponse> retornarTodosFuncionarios() {
        log.info("[inicio] FuncionarioApplicationService - retornarTodosFuncionarios");
        List<Funcionario> funcionarios = funcionarioRepository.todosFuncionarios();
        List<FuncionarioSimpleResponse> funcionarioSimpleResponses
                = FuncionarioSimpleResponse.converter(funcionarios);
        log.info("[finaliza] FuncionarioApplicationService - retornarTodosFuncionarios");
        return funcionarioSimpleResponses;
    }
}
