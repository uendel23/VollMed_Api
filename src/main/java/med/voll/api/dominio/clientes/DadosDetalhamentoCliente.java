package med.voll.api.dominio.clientes;

import med.voll.api.dominio.endereco.Endereco;

public record DadosDetalhamentoCliente(Long id, String nome, String email, String cpf, String telefone, Endereco endereco) {
    public DadosDetalhamentoCliente(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getCpf(),  cliente.getTelefone(), cliente.getEndereco());
    }

}
