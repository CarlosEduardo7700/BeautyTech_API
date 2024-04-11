package br.com.fiap.beautytech.dtos;

import br.com.fiap.beautytech.models.Cliente;
import br.com.fiap.beautytech.models.enums.EstadoCivil;
import br.com.fiap.beautytech.models.enums.Genero;

import java.time.LocalDate;

public record ListagemClienteDto(
        Long id,
        String cpf,
        String nome,
        String email,
        LocalDate dataDeCadastro,
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
