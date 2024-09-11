package br.com.fiap.beautytech.dtos.clientes;

import br.com.fiap.beautytech.models.enums.EstadoCivil;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Schema(description = "Informações para cadastro de um Cliente")
public record CadastroClienteDto(
        @Schema(description = "CPF do Cliente")
        @NotBlank(message = "CPF é obrigatório!")
        @Size(max = 11, min = 11, message = "CPF tem que ter 11 números.")
        String cpf,
        @Schema(description = "Nome do Cliente")
        @NotBlank(message = "Nome é obrigatório!")
        @Size(max = 150)
        String nome,
        @Schema(description = "Email do Cliente")
        @Email(message = "Formato de email inválido!")
        @NotBlank(message = "Email é obrigatório!")
        @Size(max = 100)
        String email,
        @Schema(description = "Senha do Cliente")
        @NotBlank(message = "Senha é obrigatório!")
        String senha,
        @Schema(description = "Data de Nascimento do Cliente")
        @NotNull(message = "Data de nascimento é obrigatória!")
        @Past(message = "Data de nascimento precisa ser no passado.")
        LocalDate dataDeNascimento,
        @Schema(description = "Estado Civil do Cliente")
        @NotNull(message = "Estado Civil é obrigatório!")
        EstadoCivil estadoCivil,
        @Schema(description = "ID do Gênero do Cliente")
        @NotNull(message = "Genero é obrigatório!")
        Long idGenero,
        @Schema(description = "DDI do Telefone do Cliente")
        @NotNull(message = "DDI do telefone é obrigatório!")
        @Size(max = 3)
        String ddiTelefone,
        @Schema(description = "DDD do Telefone do Cliente")
        @NotNull(message = "DDD do telefone é obrigatório!")
        Integer dddTelefone,
        @Schema(description = "Número de Telefone do Cliente")
        @NotNull(message = "Número do telefone é obrigatório!")
        @Size(max = 9)
        String numeroTelefone
) {
}