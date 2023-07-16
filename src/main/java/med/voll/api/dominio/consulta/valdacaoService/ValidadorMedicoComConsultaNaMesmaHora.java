package med.voll.api.dominio.consulta.valdacaoService;

import med.voll.api.dominio.ValidacaoException;
import med.voll.api.dominio.consulta.ConsultaRepository;
import med.voll.api.dominio.consulta.DadosAgendamentoConsultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComConsultaNaMesmaHora implements ValidadorAgendamentoDeConsulta{
    @Autowired
    private ConsultaRepository repository;

    public void validar (DadosAgendamentoConsultas dados){
        var medicoPossuiOutraConsultaNoMsmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiOutraConsultaNoMsmoHorario) {
            throw new ValidacaoException("Médico já possui outra consulta agendada nesse mesmo horário");
        }
    }
}
