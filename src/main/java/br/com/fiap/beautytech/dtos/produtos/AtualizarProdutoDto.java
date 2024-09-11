package br.com.fiap.beautytech.dtos.produtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "Informações para atualização de um Produto")
public record AtualizarProdutoDto(
        @Schema(description = "Nome do Produto")
        @Size(max = 150)
        String nome,
        @Schema(description = "Descrição do Produto")
        @Size(max = 150)
        String descricao,
        @Schema(description = "Preço do Produto")
        @Digits(integer = 8, fraction = 2)
        BigDecimal preco,
        @Schema(description = "Data de Fabricação do Produto")
        LocalDate dataDeFabricacao,
        @Schema(description = "Validade do Produto")
        LocalDate validade,
        @Schema(description = "Caminho da Imagem do Produto")
        @Size(max = 300)
        String caminhoDaImagem
) {
}
