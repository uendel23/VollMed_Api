package med.voll.api.dominio.clientes;

import med.voll.api.dominio.endereco.Endereco;
public record DadosListagemClientes(
        Long id,
        String nome,
        String email,
        String cpf,
        String telefone,
        Endereco endereco)
{

    public DadosListagemClientes (Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getCpf(), cliente.getTelefone(),cliente.getEndereco());
    }


}
