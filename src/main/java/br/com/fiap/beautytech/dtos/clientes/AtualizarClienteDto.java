package br.com.fiap.beautytech.dtos.clientes;

import br.com.fiap.beautytech.models.enums.EstadoCivil;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Schema(description = "Informações para atualização de um Cliente")
public record AtualizarClienteDto(
        @Schema(description = "CPF do Cliente")
        @Size(max = 11, min = 11, message = "CPF tem que ter 11 números.")
        String cpf,
        @Schema(description = "Nome do Cliente")
        @Size(max = 150)
        String nome,
        @Schema(description = "Email do Cliente")
        @Email(message = "Formato de email inválido!")
        @Size(max = 100)
        String email,
        @Schema(description = "Senha do Cliente")
        String senha,
        @Schema(description = "Data de Nascimento do Cliente")
        @Past(message = "Data de nascimento precisa ser no passado.")
        LocalDate dataDeNascimento,
        @Schema(description = "Estado Civil do Cliente")
        EstadoCivil estadoCivil,
        @Schema(description = "Data de Exclusão do Cliente")
        LocalDate dataDeExclusao,
        @Schema(description = "ID do Gênero do Cliente")
        Long idGenero,
        @Schema(description = "DDI do Telefone do Cliente")
        @Size(max = 3)
        String ddiTelefone,
        @Schema(description = "DDD do Telefone do Cliente")
        Integer dddTelefone,
        @Schema(description = "Número de Telefone do Cliente")
        @Size(max = 9)
        String numeroTelefone
) {
}
