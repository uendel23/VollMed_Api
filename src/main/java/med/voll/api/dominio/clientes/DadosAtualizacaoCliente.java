package med.voll.api.dominio.clientes;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dominio.endereco.DadosEndereco;

public record DadosAtualizacaoCliente(@NotNull Long id, String nome, String email, String telefone, DadosEndereco endereco) {

}
