package funcionarios.domain;

import funcionarios.application.api.FuncionarioSalvarRequest;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(FuncionarioSalvarRequest funcionarioSalvarRequest) {
        this.cep = funcionarioSalvarRequest.getCep();
        this.logradouro = funcionarioSalvarRequest.getLogradouro();
        this.complemento = funcionarioSalvarRequest.getComplemento();
        this.bairro = funcionarioSalvarRequest.getBairro();
        this.cidade = funcionarioSalvarRequest.getCidade();
        this.estado = funcionarioSalvarRequest.getEstado();
    }
}
