package com.wakanda.gestao_funcionarios;

import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSalvarRequest;
import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSalvoResponse;
import com.wakanda.gestao_funcionarios.funcionarios.application.api.FuncionarioSingleResponse;
import com.wakanda.gestao_funcionarios.funcionarios.domain.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataHelper {
    private static final UUID funcionario1 = UUID.fromString("a713162f-20a9-4db9-a85b-90cd51ab18f4");

    public static Funcionario createFuncionario() {
        return Funcionario.builder().id(funcionario1).build();
    }

    public static FuncionarioSalvarRequest createFuncionarioSalvarRequest() {
        return FuncionarioSalvarRequest.builder().nome("Pedro Lucas").build();
    }

    public static FuncionarioSalvoResponse createFuncionarioSalvoResponse() {
        return new FuncionarioSalvoResponse(createFuncionario());
    }

    public static List<Funcionario> createFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(DataHelper.createFuncionario());
        funcionarios.add(DataHelper.createFuncionario());
        funcionarios.add(DataHelper.createFuncionario());

        return funcionarios;
    }

    public static FuncionarioSingleResponse createFuncionarioSingleResponse() {
        return new FuncionarioSingleResponse(createFuncionario());
    }
}
