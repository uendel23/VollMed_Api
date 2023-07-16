package med.voll.api.controller;


import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import med.voll.api.dominio.clientes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
@SecurityRequirement(name = "bearer-key")
public class ClientesController {

    @Autowired
   private ClientesRepository repository;

    @GetMapping
    public ResponseEntity<Page<DadosListagemClientes>> listar (@PageableDefault(size=10, sort={"nome"} ) Pageable paginacao){

        var page = repository.findAllByAtivoTrue(paginacao);

        return ResponseEntity.ok(page);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroClientes DadosCientes, UriComponentsBuilder uriBuilder){
        Cliente cliente = new Cliente(DadosCientes);
        repository.save(cliente);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));

    }
    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoCliente> atualizar(@RequestBody DadosAtualizacaoCliente dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativar(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.inativar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }



}
