package med.voll.api.dominio.medico;


public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {

    //criando o construtor pegando como parametro a entidade Medico e dentro dele chama o construtor principal
    // atraves do this declarado na assinatura do record, passando cada um dos campos.
    public DadosListagemMedico(Medico medico){
    this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }


}
