package med.voll.api.dominio.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dominio.endereco.DadosEndereco;

public record DadosAtualizacaoMediscos(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {

}
