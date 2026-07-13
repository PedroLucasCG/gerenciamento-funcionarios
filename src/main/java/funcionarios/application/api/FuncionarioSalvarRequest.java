package funcionarios.application.api;

import funcionarios.domain.Designacao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioSalvarRequest {
    private String nome;
    private Designacao designacao;
    private Double salario;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
}
