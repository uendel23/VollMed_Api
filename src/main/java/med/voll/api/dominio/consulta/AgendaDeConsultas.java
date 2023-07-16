package med.voll.api.dominio.consulta;


import med.voll.api.dominio.ValidacaoException;
import med.voll.api.dominio.clientes.Cliente;
import med.voll.api.dominio.clientes.ClientesRepository;
import med.voll.api.dominio.consulta.valdacaoService.ValidadorAgendamentoDeConsulta;
import med.voll.api.dominio.medico.Medico;
import med.voll.api.dominio.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AgendaDeConsultas {
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validador;


    public DadosdetalhamentoConsulta agendar(DadosAgendamentoConsultas dados){
        if (!clientesRepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("Id do paciente não informado");
        }

        if (dados.idMedico() != null && !medicoRepository.existsById(dados.idMedico())){
            throw new ValidacaoException("Id do Medico não informado");
        }

        validador.forEach(v -> v.validar(dados));

        var paciente = clientesRepository.findById(dados.idPaciente()).get();
        var medico = ecolherMedico(dados);
        if (medico ==null){
            throw new ValidacaoException("Não posssui medico disponivel nessa data");
        }
        var consulta = new Consulta(null,medico, paciente, dados.data());
        consultaRepository.save(consulta);

        return new DadosdetalhamentoConsulta(consulta);
    }

    private Medico ecolherMedico(DadosAgendamentoConsultas dados) {
        if (dados.idMedico() != null){
            return medicoRepository.getReferenceById(dados.idMedico());
        }
        if (dados.especialidade() == null){
            throw  new ValidacaoException("Especialidade é obrigatória quando medico não for escolhido");
        }

        return medicoRepository.escolherMedicoAleatorioNaData(dados.especialidade(), dados.data());

    }

    public void cancelar(Long id) {
        consultaRepository.deleteById(id);
    }
}
