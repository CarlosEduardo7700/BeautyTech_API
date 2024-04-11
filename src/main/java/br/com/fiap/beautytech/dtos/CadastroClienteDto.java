package br.com.fiap.beautytech.dtos;

import br.com.fiap.beautytech.models.enums.EstadoCivil;
import br.com.fiap.beautytech.models.enums.Genero;
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
        @Size(max = 100)
        String email,
        @NotNull(message = "Data de nascimento é obrigatória!")
        @Past(message = "Data de nascimento precisa ser no passado.")
        LocalDate dataDeNascimento,
        @NotNull(message = "Estado Civil é obrigatório!")
        EstadoCivil estadoCivil,
        @NotNull(message = "Gênero é obrigatório!")
        Genero genero
) {
}
