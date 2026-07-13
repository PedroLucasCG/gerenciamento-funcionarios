package funcionarios.domain;

import funcionarios.application.api.FuncionarioSalvarRequest;
import lombok.*;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Funcionario {
    private UUID id;
    private String nome;
    private Designacao designacao;
    private Double salario;
    private Endereco endereco;

    public Funcionario(FuncionarioSalvarRequest  funcionarioSalvarRequest) {
        this.id = UUID.randomUUID();
        this.nome = funcionarioSalvarRequest.getNome();
        this.designacao = funcionarioSalvarRequest.getDesignacao();
        this.salario = funcionarioSalvarRequest.getSalario();
        this.endereco = new Endereco(funcionarioSalvarRequest);
    }
}
