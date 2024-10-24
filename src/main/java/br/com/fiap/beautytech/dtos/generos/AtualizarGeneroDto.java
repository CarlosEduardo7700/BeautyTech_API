package br.com.fiap.beautytech.dtos.generos;

import jakarta.validation.constraints.Size;

public record AtualizarGeneroDto(
        @Size(max = 50)
        String nome,
        @Size(max = 100)
        String descricao
) {
}
