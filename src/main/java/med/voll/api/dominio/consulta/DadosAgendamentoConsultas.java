package med.voll.api.dominio.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.dominio.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosAgendamentoConsultas(
        @NotNull
        Long idPaciente,

        Long idMedico,

        @NotNull
        @Future
        LocalDateTime data,

        Especialidade especialidade
) {

}
