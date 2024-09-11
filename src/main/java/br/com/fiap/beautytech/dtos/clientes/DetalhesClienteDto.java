package br.com.fiap.beautytech.dtos.clientes;

import br.com.fiap.beautytech.models.Cliente;
import br.com.fiap.beautytech.models.Genero;
import br.com.fiap.beautytech.models.Telefone;
import br.com.fiap.beautytech.models.enums.EstadoCivil;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(description = "Informações de um Cliente")
public record DetalhesClienteDto(
        @Schema(description = "ID do Cliente")
        Long id,
        @Schema(description = "CPF do Cliente")
        String cpf,
        @Schema(description = "Nome do Cliente")
        String nome,
        @Schema(description = "Email do Cliente")
        String email,
        @Schema(description = "Senha do Cliente")
        String senha,
        @Schema(description = "Data de Nascimento do Cliente")
        LocalDate dataDeNascimento,
        @Schema(description = "Estado Civil do Cliente")
        EstadoCivil estadoCivil,
        @Schema(description = "Data de Cadastro do Cliente")
        LocalDate dataDeCadastro,
        @Schema(description = "Data de Exclusão do Cliente")
        LocalDate dataDeExclusao,
        @Schema(description = "Nome do Gênero do Cliente")
        String nomeGenero,
        @Schema(description = "DDI do Telefone do Cliente")
        String ddiTelefone,
        @Schema(description = "DDD do Cliente")
        Integer dddTelefone,
        @Schema(description = "Número do Cliente")
        String numeroTelefone
) {
    public DetalhesClienteDto(Cliente cliente) {
        this(
                cliente.getId(),
                cliente.getCpf(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getSenha(),
                cliente.getDataDeNascimento(),
                cliente.getEstadoCivil(),
                cliente.getDataDeCadastro(),
                cliente.getDataDeExclusao(),
                cliente.getGenero().getNome(),
                cliente.getTelefone().getDdi(),
                cliente.getTelefone().getDdd(),
                cliente.getTelefone().getNumero()
        );
    }
}
