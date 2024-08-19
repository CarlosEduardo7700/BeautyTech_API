package br.com.fiap.beautytech.repositories;

import br.com.fiap.beautytech.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmailAndSenha(String email, String senha);
    UserDetails findByEmail(String email);
}
