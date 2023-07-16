package med.voll.api.dominio.consulta.valdacaoService;

import med.voll.api.dominio.ValidacaoException;
import med.voll.api.dominio.consulta.DadosAgendamentoConsultas;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
@Component
public class ValidacaoHorarioFuncionamentoClinica implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsultas dados){
        var dataConsulta = dados.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dataConsulta.getHour() < 7;
        var depoisDoFechamentoDaClinica = dataConsulta.getHour() > 18;

        if (domingo || antesDaAberturaDaClinica || depoisDoFechamentoDaClinica){
            throw new ValidacaoException("Fora do horátrio de funcionamento");
        }



    }

}
