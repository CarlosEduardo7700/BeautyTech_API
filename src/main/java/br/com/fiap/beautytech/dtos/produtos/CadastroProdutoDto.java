package br.com.fiap.beautytech.dtos.produtos;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CadastroProdutoDto(
        @NotBlank(message = "Nome é obrigatório!")
        @Size(max = 150)
        String nome,
        @NotBlank(message = "Descrição é obrigatório!")
        @Size(max = 150)
        String descricao,
        @NotNull(message = "Preço é obrigatório!")
        @Digits(integer = 8, fraction = 2)
        BigDecimal preco,
        @NotNull(message = "Data de fabricação é obrigatória!")
        LocalDate dataDeFabricacao,
        @NotNull(message = "Data de validade é obrigatória!")
        LocalDate validade,
        @NotBlank(message = "Caminho da imagem é obrigatório!")
        @Size(max = 300)
        String caminhoDaImagem

) {
}
