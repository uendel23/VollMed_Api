package med.voll.api.dominio.consulta.valdacaoService;

import med.voll.api.dominio.ValidacaoException;
import med.voll.api.dominio.consulta.ConsultaRepository;
import med.voll.api.dominio.consulta.DadosAgendamentoConsultas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta{
    @Autowired
    private ConsultaRepository repository;

    public void validar (DadosAgendamentoConsultas dados){
        var primeirHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = repository.existsByClienteIdAndDataBetween(dados.idPaciente(), primeirHorario,ultimoHorario);

        if (pacientePossuiOutraConsultaNoDia){
            throw new ValidacaoException("Paciente já possui consulta marcada para esta data");
        }
    }

}
