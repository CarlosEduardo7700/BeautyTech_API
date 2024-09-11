package br.com.fiap.beautytech.dtos.clientes;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Informações para login de um Cliente")
public record LoginClienteDto(
        @Schema(description = "Email do Cliente")
        @Email(message = "Formato de email inválido!")
        @NotBlank(message = "Email é obrigatório!")
        @Size(max = 100)
        String email,
        @Schema(description = "Senha do Cliente")
        @NotBlank(message = "Senha é obrigatório!")
        String senha
) {
}
