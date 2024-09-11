package br.com.fiap.beautytech.dtos.clientes;

import br.com.fiap.beautytech.models.Cliente;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Informações para listagem de Clientes")
public record ListagemClienteDto(
        @Schema(description = "ID do Cliente")
        Long id,
        @Schema(description = "CPF do Cliente")
        String cpf,
        @Schema(description = "Nome do Cliente")
        String nome,
        @Schema(description = "Email do Cliente")
        String email,
        @Schema(description = "Data de Cadastro do Cliente")
        LocalDate dataDeCadastro,
        @Schema(description = "Data de Exclusão do Cliente")
        LocalDate dataDeExclusao
) {
    public ListagemClienteDto(Cliente cliente) {
        this(
                cliente.getId(),
                cliente.getCpf(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getDataDeCadastro(),
                cliente.getDataDeExclusao()
        );
    }
}
