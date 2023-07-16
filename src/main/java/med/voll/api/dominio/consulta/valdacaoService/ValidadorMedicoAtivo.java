package med.voll.api.dominio.consulta.valdacaoService;

import med.voll.api.dominio.ValidacaoException;
import med.voll.api.dominio.consulta.DadosAgendamentoConsultas;
import med.voll.api.dominio.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta{
    @Autowired
    private MedicoRepository repository;

    public void validar (DadosAgendamentoConsultas dados){
        //escolha do medico é opcional
        if (dados.idMedico()== null){
            return;
        }
        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (medicoEstaAtivo){
            throw new ValidacaoException("consulta não pode ser agendada com medico inativo");
        }

    }
}
