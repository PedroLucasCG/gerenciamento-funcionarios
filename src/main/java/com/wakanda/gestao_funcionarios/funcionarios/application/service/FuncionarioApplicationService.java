package com.wakanda.gestao_funcionarios.funcionarios.application.service;

import com.wakanda.gestao_funcionarios.funcionarios.application.api.*;
import com.wakanda.gestao_funcionarios.funcionarios.domain.Funcionario;
import com.wakanda.gestao_funcionarios.funcionarios.infra.FuncionarioRepository;
import com.wakanda.gestao_funcionarios.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class FuncionarioApplicationService implements FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    @Override
    public FuncionarioSalvoResponse salvarFuncionario(FuncionarioSalvarRequest funcionarioSalvarRequest) {
        log.info("[inicio] FuncionarioApplicationService - salvarFuncionario");
        Funcionario funcionario = new Funcionario(funcionarioSalvarRequest);
        Funcionario funcionarioSalvo = persistirFuncionario(funcionario);
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

    @Override
    public FuncionarioSingleResponse retornarFuncionario(UUID idFuncionario) {
        log.info("[inicio] FuncionarioApplicationService - retornarFuncionario");
        Funcionario funcionario = encontrarFuncionario(idFuncionario);
        FuncionarioSingleResponse funcionarioSingleResponse
                = new FuncionarioSingleResponse(funcionario);
        log.info("[finaliza] FuncionarioApplicationService - retornarFuncionario");
        return funcionarioSingleResponse;
    }

    @Override
    public Funcionario atualizarFuncionario(UUID idFuncionario, FuncionarioAtualizarRequest funcionarioAtualizarRequest) {
        log.info("[inicio] FuncionarioApplicationService - atualizarFuncionario");
        Funcionario funcionario = encontrarFuncionario(idFuncionario);
        funcionario.atualizar(funcionarioAtualizarRequest);
        Funcionario funcionarioAtualizado = persistirFuncionario(funcionario);
        log.info("[finaliza] FuncionarioApplicationService - atualizarFuncionario");
        return funcionarioAtualizado;
    }

    @Override
    public Funcionario deletarFuncionario(UUID idFuncionario) {
        log.info("[inicio] FuncionarioApplicationService - deletarFuncionario");
        Funcionario funcionario = encontrarFuncionario(idFuncionario);
        funcionarioRepository.deletarFuncionario(funcionario);
        log.info("[finaliza] FuncionarioApplicationService - deletarFuncionario");
        return funcionario;
    }

    private Funcionario persistirFuncionario(Funcionario funcionario) {
        log.info("[inicio] FuncionarioApplicationService - persisteFuncionario");
        Funcionario funcionarioSalvo = funcionarioRepository.salvarFuncionario(funcionario).orElseThrow(
                () -> APIException.build(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao salvar funcionario"));
        log.info("[finaliza] FuncionarioApplicationService - persisteFuncionario");
        return funcionarioSalvo;
    }

    private Funcionario encontrarFuncionario(UUID idFuncionario) {
        log.info("[inicio] FuncionarioApplicationService - encontrarFuncionario");
        Funcionario funcionario = funcionarioRepository.retornarFuncionarioPorId(idFuncionario).orElseThrow(
                () -> APIException.build(HttpStatus.NOT_FOUND, "Funcionario não encontrado"));
        log.info("[finaliza] FuncionarioApplicationService - encontrarFuncionario");
        return funcionario;
    }
}
