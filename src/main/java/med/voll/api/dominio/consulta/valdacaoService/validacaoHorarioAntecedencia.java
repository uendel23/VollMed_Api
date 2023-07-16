package med.voll.api.dominio.consulta.valdacaoService;

import med.voll.api.dominio.ValidacaoException;
import med.voll.api.dominio.consulta.DadosAgendamentoConsultas;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
@Component
public class validacaoHorarioAntecedencia  implements ValidadorAgendamentoDeConsulta{

    public void validar(DadosAgendamentoConsultas dados){
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();
        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
        throw new ValidacaoException("A consulta deve " +
                "ser marcada com  no mínimo 30 minutos de antecedência");
        }

    }
}
