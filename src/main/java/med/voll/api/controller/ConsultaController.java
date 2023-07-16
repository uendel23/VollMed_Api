package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.dominio.consulta.AgendaDeConsultas;
import med.voll.api.dominio.consulta.DadosAgendamentoConsultas;
import med.voll.api.dominio.consulta.DadosdetalhamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agenda;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsultas dados){
       var dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity cancelarConsulta(@PathVariable Long id){
          agenda.cancelar(id);
         return ResponseEntity.noContent().build();
    }
}
