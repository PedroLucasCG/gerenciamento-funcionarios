package funcionarios.application.api;

import funcionarios.domain.Funcionario;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/funcionario")
public interface FuncionarioAPI {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    FuncionarioSalvoResponse criarFuncionario(@RequestBody @Valid FuncionarioSalvarRequest funcionarioSalvarRequest);
}
