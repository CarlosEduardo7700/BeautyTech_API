package br.com.fiap.beautytech.dtos.produtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "Informações para cadastro de um Produto")
public record CadastroProdutoDto(
        @Schema(description = "Nome do Produto")
        @NotBlank(message = "Nome é obrigatório!")
        @Size(max = 150)
        String nome,
        @Schema(description = "Descrição do Produto")
        @NotBlank(message = "Descrição é obrigatório!")
        @Size(max = 150)
        String descricao,
        @Schema(description = "Preço do Produto")
        @NotNull(message = "Preço é obrigatório!")
        @Digits(integer = 8, fraction = 2)
        BigDecimal preco,
        @Schema(description = "Data de Fabricação do Produto")
        @NotNull(message = "Data de fabricação é obrigatória!")
        LocalDate dataDeFabricacao,
        @Schema(description = "Validade do Produto")
        @NotNull(message = "Data de validade é obrigatória!")
        LocalDate validade,
        @Schema(description = "Caminho da Imagem do Produto")
        @NotBlank(message = "Caminho da imagem é obrigatório!")
        @Size(max = 300)
        String caminhoDaImagem

) {
}
