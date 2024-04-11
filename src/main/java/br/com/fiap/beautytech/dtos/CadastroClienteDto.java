package br.com.fiap.beautytech.dtos;

import br.com.fiap.beautytech.models.enums.EstadoCivil;
import br.com.fiap.beautytech.models.enums.Genero;

import java.time.LocalDate;

public record CadastroClienteDto(
        String cpf,
        String nome,
        String email,
        LocalDate dataDeNascimento,
        EstadoCivil estadoCivil,
        Genero genero
) {
}
