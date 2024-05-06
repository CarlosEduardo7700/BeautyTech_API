package br.com.fiap.beautytech.dtos.clientes;

import br.com.fiap.beautytech.models.enums.EstadoCivil;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record CadastroClienteDto(
        @NotBlank(message = "CPF é obrigatório!")
        @Size(max = 11, min = 11, message = "CPF tem que ter 11 números.")
        String cpf,
        @NotBlank(message = "Nome é obrigatório!")
        @Size(max = 150)
        String nome,
        @Email(message = "Formato de email inválido!")
        @NotBlank(message = "Email é obrigatório!")
        @Size(max = 100)
        String email,
        @NotBlank(message = "Senha é obrigatório!")
        @Size(max = 50)
        String senha,
        @NotNull(message = "Data de nascimento é obrigatória!")
        @Past(message = "Data de nascimento precisa ser no passado.")
        LocalDate dataDeNascimento,
        @NotNull(message = "Estado Civil é obrigatório!")
        EstadoCivil estadoCivil,
        @NotNull(message = "Genero é obrigatório!")
        Long idGenero,
        @NotNull(message = "Estado Civil é obrigatório!")
        Long idTelefone
) {
}
