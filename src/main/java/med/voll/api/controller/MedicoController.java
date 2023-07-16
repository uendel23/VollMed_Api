package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.voll.api.dominio.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
@SecurityRequirement(name = "bearer-key")
public class MedicoController {

	@Autowired// o Autowired faz com que o spring instancie a interface MedicoRepository
	private MedicoRepository repository;

	@PostMapping
	@Transactional
	public ResponseEntity cadastrar (@RequestBody @Valid DadosCadastroMediscos dados, UriComponentsBuilder uriBuilder) {
		var medico = new Medico(dados);
		repository.save(medico);

		var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();

		return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
	}


	@GetMapping
	public ResponseEntity<Page<DadosListagemMedico>> listar (@PageableDefault(size=10, sort={"nome"} ) Pageable paginacao){
		var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);

		return ResponseEntity.ok(page);
	}

	@PutMapping
	@Transactional // transactional faz com que o metodo aconteca no momento da transação
	public ResponseEntity atualizar (@RequestBody @Valid DadosAtualizacaoMediscos dados){
		var medico = repository.getReferenceById(dados.id());
		medico.atualizarInfomracoes(dados);

		return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
	}

	@DeleteMapping("/{id}")//a anotação @PathVariable é para informar ao Spring que o parametro dentro das chaves é o Long id
	@Transactional
	public ResponseEntity excluir (@PathVariable Long id){
	//repository.deleteById(id);
		var medico = repository.getReferenceById(id);
		medico.excuir();
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity detalhar(@PathVariable Long id){
		var medico = repository.getReferenceById(id);
		return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
	}



	
}

