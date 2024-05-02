package br.com.fiap.beautytech.dtos;

import br.com.fiap.beautytech.models.Cliente;
import br.com.fiap.beautytech.models.enums.EstadoCivil;

import java.time.LocalDate;

public record DetalhesClienteDto(
        Long id,
        String cpf,
        String nome,
        String email,
        LocalDate dataDeNascimento,
        EstadoCivil estadoCivil,
        LocalDate dataDeCadastro,
        LocalDate dataDeExclusao
) {
    public DetalhesClienteDto(Cliente cliente) {
        this(
                cliente.getId(),
                cliente.getCpf(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getDataDeNascimento(),
                cliente.getEstadoCivil(),
                cliente.getDataDeCadastro(),
                cliente.getDataDeExclusao()
        );
    }
}
