package funcionarios.domain;

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
}
