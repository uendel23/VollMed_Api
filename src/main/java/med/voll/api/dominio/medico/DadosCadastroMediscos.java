package med.voll.api.dominio.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.dominio.endereco.DadosEndereco;

public record DadosCadastroMediscos(
       @NotNull
       @NotBlank
        String nome,
        @NotNull
        @NotBlank
        @Email
        String email,

       @NotBlank
       String telefone,

       @NotBlank
       @Pattern(regexp = "\\d{4,6}")
        String crm,
       @NotNull
        Especialidade especialidade,
       @NotNull
       @Valid
       DadosEndereco endereco) {

	
}
