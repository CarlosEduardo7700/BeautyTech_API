package br.com.fiap.beautytech.dtos.clientes;

import br.com.fiap.beautytech.models.enums.EstadoCivil;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AtualizarClienteDto(
        @Size(max = 11, min = 11, message = "CPF tem que ter 11 números.")
        String cpf,
        @Size(max = 150)
        String nome,
        @Email(message = "Formato de email inválido!")
        @Size(max = 100)
        String email,
        @Size(max = 50)
        String senha,
        @Past(message = "Data de nascimento precisa ser no passado.")
        LocalDate dataDeNascimento,
        EstadoCivil estadoCivil,
        LocalDate dataDeExclusao,
        Long idGenero,
        Long idTelefone
) {
}
