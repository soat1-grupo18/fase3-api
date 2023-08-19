package br.com.fiap.soat.techChallenge.application.adapter.outbound.repository.jpa;
import br.com.fiap.soat.techChallenge.application.adapter.outbound.repository.jpa.entity.ProdutoEntity;
import br.com.fiap.soat.techChallenge.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProdutoJpaRepository extends JpaRepository<ProdutoEntity, UUID> {
    List<ProdutoEntity> findByCategoria(Produto.TipoDeProduto categoria);
}
