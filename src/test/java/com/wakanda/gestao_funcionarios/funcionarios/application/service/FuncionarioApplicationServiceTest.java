package com.wakanda.gestao_funcionarios.funcionarios.application.service;

import com.wakanda.gestao_funcionarios.DataHelper;
import com.wakanda.gestao_funcionarios.funcionarios.application.api.*;
import com.wakanda.gestao_funcionarios.funcionarios.domain.Funcionario;
import com.wakanda.gestao_funcionarios.funcionarios.infra.FuncionarioRepository;
import com.wakanda.gestao_funcionarios.handler.APIException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FuncionarioApplicationServiceTest {
    @InjectMocks
    private FuncionarioApplicationService service;

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @Test
    void persisteFuncionarioComSucesso() {
        Funcionario funcionario = DataHelper.createFuncionario();
        FuncionarioSalvarRequest funcionarioSalvarRequest = DataHelper.createFuncionarioSalvarRequest();
        FuncionarioSalvoResponse funcionarioSalvoResponse = DataHelper.createFuncionarioSalvoResponse();

        when(funcionarioRepository.salvarFuncionario(any())).thenReturn(Optional.of(funcionario));

        FuncionarioSalvoResponse funcionarioResponse = service.salvarFuncionario(funcionarioSalvarRequest);

        verify(funcionarioRepository, times(1)).salvarFuncionario(any());
        assertEquals(funcionarioSalvoResponse.getNome(), funcionarioResponse.getNome());
    }

    @Test
    void erro500NoSalvarFuncionario() {
        FuncionarioSalvarRequest funcionarioSalvarRequest = DataHelper.createFuncionarioSalvarRequest();

        when(funcionarioRepository.salvarFuncionario(any())).thenReturn(Optional.empty());
        APIException exception = assertThrows(APIException.class, () -> {
            service.salvarFuncionario(funcionarioSalvarRequest);
        });

        verify(funcionarioRepository, times(1)).salvarFuncionario(any());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getStatusException());
    }

    @Test
    void retornarTodosFuncionariosComSucesso() {
        List<Funcionario> funcionarios = DataHelper.createFuncionarios();

        when(funcionarioRepository.todosFuncionarios()).thenReturn(funcionarios);
        List<FuncionarioSimpleResponse> funcionarioSimpleResponses
                = service.retornarTodosFuncionarios();

        verify(funcionarioRepository, times(1)).todosFuncionarios();
        assertEquals(funcionarioSimpleResponses.get(0).getNome(), funcionarioSimpleResponses.get(0).getNome());
        assertEquals(funcionarioSimpleResponses.size(), funcionarioSimpleResponses.size());
    }

    @Test
    void retornarFuncionarioSingularComSucesso() {
        Funcionario funcionario = DataHelper.createFuncionario();
        FuncionarioSingleResponse funcionarioSingleResponse = DataHelper.createFuncionarioSingleResponse();

        when(funcionarioRepository.retornarFuncionarioPorId(any())).thenReturn(Optional.of(funcionario));

        FuncionarioSingleResponse funcionarioResponse = service.retornarFuncionario(funcionario.getId());

        verify(funcionarioRepository, times(1)).retornarFuncionarioPorId(any());
        assertEquals(funcionarioResponse.getId(), funcionarioSingleResponse.getId());
    }

    @Test
    void erroAoRetornarFuncionarioSingular() {
        Funcionario funcionario = DataHelper.createFuncionario();

        when(funcionarioRepository.retornarFuncionarioPorId(any())).thenReturn(Optional.empty());

        APIException exception = assertThrows(APIException.class, () -> {
            service.retornarFuncionario(funcionario.getId());
        });

        verify(funcionarioRepository, times(1)).retornarFuncionarioPorId(any());
        assertEquals(HttpStatus.NOT_FOUND, exception.getStatusException());
    }

    @Test
    void atualizarFuncionarioComSucesso() {
        Funcionario funcionario = DataHelper.createFuncionario();
        FuncionarioAtualizarRequest funcionarioAtualizarRequest = DataHelper.createFuncionarioAtualizarRequest();

        when(funcionarioRepository.retornarFuncionarioPorId(any())).thenReturn(Optional.of(funcionario));
        when(funcionarioRepository.salvarFuncionario(any())).thenReturn(Optional.of(funcionario));

        Funcionario funcionarioRetorno = service.atualizarFuncionario(funcionario.getId(), funcionarioAtualizarRequest);

        verify(funcionarioRepository, times(1)).salvarFuncionario(any());
        verify(funcionarioRepository, times(1)).retornarFuncionarioPorId(any());
        assertEquals(funcionarioRetorno.getNome(), funcionarioAtualizarRequest.getNome());
    }
}