package br.com.fiap.beautytech.dtos.clientes;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginClienteDto(
        @Email(message = "Formato de email inválido!")
        @NotBlank(message = "Email é obrigatório!")
        @Size(max = 100)
        String email,
        @NotBlank(message = "Senha é obrigatório!")
        @Size(max = 50)
        String senha
) {
}
