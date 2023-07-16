package med.voll.api.dominio.consulta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    boolean existsByMedicoIdAndData(Long idMedico, LocalDateTime data);

    boolean existsByClienteIdAndDataBetween(Long idPaciente, LocalDateTime primeirHorario, LocalDateTime ultimoHorario);
}
