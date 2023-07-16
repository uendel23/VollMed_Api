package med.voll.api.dominio.clientes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dominio.endereco.Endereco;

@Entity(name = "cliente")
@Table(name = "clientes")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    @Embedded
    private Endereco endereco;

    private boolean ativo;



    public Cliente (DadosCadastroClientes dados){
        this.ativo= true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
    }


    public  void  atualizar(DadosAtualizacaoCliente dados) {
            if(dados.nome() !=null) {
                this.nome = dados.nome();
            }
            if (dados.telefone() != null){
                this.telefone = dados.telefone();
            }
            if(dados.endereco() != null){
                this.endereco.atualizarInformacoes(dados.endereco());
            }
        }

    public void inativar() {
        this.ativo = false;
    }
}



