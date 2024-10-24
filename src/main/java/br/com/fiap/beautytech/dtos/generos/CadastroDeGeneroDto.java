package br.com.fiap.beautytech.dtos.generos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastroDeGeneroDto(
        @NotBlank(message = "Nome é obrigatório!")
        @Size(max = 50)
        String nome,
        @NotBlank(message = "Descrição é obrigatório!")
        @Size(max = 100)
        String descricao
) {
}
