package br.com.fiap.beautytech.repositories;

import br.com.fiap.beautytech.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produto, Long> {
}
