package com.wakanda.gestao_funcionarios.funcionarios.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/funcionario")
public interface FuncionarioAPI {
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    FuncionarioSalvoResponse criarFuncionario(@RequestBody @Valid FuncionarioSalvarRequest funcionarioSalvarRequest);

    @GetMapping(value = "/todos")
    @ResponseStatus(HttpStatus.OK)
    List<FuncionarioSimpleResponse> recuperarTodosFuncionarios();

    @GetMapping(value = "/{idFuncionario}")
    @ResponseStatus(HttpStatus.OK)
    FuncionarioSingleResponse recuperarFuncionarioUnico(@PathVariable UUID idFuncionario);

    @PatchMapping(value = "/{idFuncionario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void atualizarFuncionario(
            @PathVariable UUID idFuncionario,
            @RequestBody FuncionarioAtualizarRequest funcionarioAtualizarRequest);

    @DeleteMapping(value = "/{idFuncionario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletarFuncionario(@PathVariable UUID idFuncionario);
}
