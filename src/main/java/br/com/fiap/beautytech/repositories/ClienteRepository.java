package br.com.fiap.beautytech.repositories;

import br.com.fiap.beautytech.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmailAndSenha(String email, String senha);
}
