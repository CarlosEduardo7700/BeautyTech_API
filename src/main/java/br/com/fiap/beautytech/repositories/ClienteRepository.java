package br.com.fiap.beautytech.repositories;

import br.com.fiap.beautytech.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
