package med.voll.api.dominio.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {

    private String longadouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco endereco) {
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.longadouro = endereco.longadouro();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
        this.complemento = endereco.complemento();
        this.numero = endereco.numero();
    }



    public void atualizarInformacoes(DadosEndereco dados){
        if (dados.longadouro() != null){
            this.longadouro = dados.longadouro();
        }
        if (dados.bairro() != null){
            this.bairro = dados.bairro();
        }
        if (dados.cep() != null){
            this.cep = dados.cep();
        }
        if (dados.uf() != null){
            this.uf = dados.uf();
        }
        if (dados.cidade() != null){
            this.cidade = dados.cidade();
        }
        if (dados.complemento() != null){
            this.complemento = dados.complemento();
        }
        if (dados.numero() != null){
            this.numero = dados.numero();
        }
    }
}
