package med.voll.api.dominio.consulta.valdacaoService;

import med.voll.api.dominio.consulta.DadosAgendamentoConsultas;
import org.springframework.stereotype.Component;

@Component
public interface ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsultas dado);
}
