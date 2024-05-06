package br.com.fiap.beautytech.repositories;

import br.com.fiap.beautytech.models.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
