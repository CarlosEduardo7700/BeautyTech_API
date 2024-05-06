package br.com.fiap.beautytech.dtos.produtos;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public record AtualizarProdutoDto(
        @Size(max = 150)
        String nome,
        @Size(max = 150)
        String descricao,
        @Digits(integer = 8, fraction = 2)
        BigDecimal preco,
        LocalDate dataDeFabricacao,
        LocalDate validade,
        @Size(max = 300)
        String caminhoDaImagem
) {
}
