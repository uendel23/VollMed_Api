package med.voll.api.dominio.consulta;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
public record DadosdetalhamentoConsulta(Long id,Long idMedico,Long idPaciente,LocalDateTime data) {

    public DadosdetalhamentoConsulta(Consulta consulta) {
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getCliente().getId(), consulta.getData());
    }
}
