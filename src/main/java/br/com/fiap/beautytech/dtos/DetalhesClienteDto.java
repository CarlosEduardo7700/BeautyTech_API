package br.com.fiap.beautytech.dtos;

import br.com.fiap.beautytech.models.Cliente;
import br.com.fiap.beautytech.models.enums.EstadoCivil;
import br.com.fiap.beautytech.models.enums.Genero;

import java.time.LocalDate;

public record DetalhesClienteDto(
        Long id,
        String cpf,
        String nome,
        String email,
        LocalDate dataDeNascimento,
        EstadoCivil estadoCivil,
        Genero genero,
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
                cliente.getGenero(),
                cliente.getDataDeCadastro(),
                cliente.getDataDeExclusao()
        );
    }
}
