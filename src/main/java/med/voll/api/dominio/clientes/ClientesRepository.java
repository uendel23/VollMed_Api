package med.voll.api.dominio.clientes;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientesRepository extends JpaRepository <Cliente, Long>{
    Page<DadosListagemClientes> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select p.ativo
            from cliente p
            where
            p.id = :id
            """)
    Boolean findAtivoById(Long id);
}
