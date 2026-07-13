package com.wakanda.gestao_funcionarios.funcionarios.application.service;

import com.wakanda.gestao_funcionarios.DataHelper;
import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSalvarRequest;
import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSalvoResponse;
import com.wakanda.gestao_funcionarios.funcionarios.domain.Funcionario;
import com.wakanda.gestao_funcionarios.funcionarios.infra.FuncionarioRepository;
import com.wakanda.gestao_funcionarios.handler.APIException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

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
    void salvarFuncionarioComSucesso() {
        Funcionario funcionario = DataHelper.createFuncionario();
        FuncionarioSalvarRequest funcionarioSalvarRequest = DataHelper.createFuncionarioSalvarRequest();
        FuncionarioSalvoResponse funcionarioSalvoResponse = DataHelper.createFuncionarioSalvoResponse();

        when(funcionarioRepository.salvarFuncionario(any())).thenReturn(Optional.of(funcionario));

        FuncionarioSalvoResponse funcionarioResponse = service.salvarFuncionario(funcionarioSalvarRequest);

        verify(funcionarioRepository, times(1)).salvarFuncionario(any());
        assertEquals(funcionarioSalvoResponse.getNome(), funcionarioResponse.getNome());
    }

    @Test
    void errao500NoSalvarFuncionario() {
        FuncionarioSalvarRequest funcionarioSalvarRequest = DataHelper.createFuncionarioSalvarRequest();

        when(funcionarioRepository.salvarFuncionario(any())).thenReturn(Optional.empty());
        APIException exception = assertThrows(APIException.class, () -> {
            service.salvarFuncionario(funcionarioSalvarRequest);
        });

        verify(funcionarioRepository, times(1)).salvarFuncionario(any());
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, exception.getStatusException());
    }
}