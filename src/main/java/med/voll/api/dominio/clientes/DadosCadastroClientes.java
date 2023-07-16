package med.voll.api.dominio.clientes;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.dominio.endereco.DadosEndereco;


public record DadosCadastroClientes(
        @NotBlank
        @NotNull
        String nome,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String cpf,
        @NotBlank
        String telefone,

        @NotNull
        @Valid
        DadosEndereco endereco

) {

}
