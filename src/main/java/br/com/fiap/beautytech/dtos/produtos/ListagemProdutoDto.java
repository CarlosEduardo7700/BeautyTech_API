package br.com.fiap.beautytech.dtos.produtos;

import br.com.fiap.beautytech.models.Produto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Informações para listagem de um Produto")
public record ListagemProdutoDto(
        @Schema(description = "ID do Produto")
        Long id,
        @Schema(description = "Nome do Produto")
        String nome,
        @Schema(description = "Descrição do Produto")
        String descricao,
        @Schema(description = "Preço do Produto")
        BigDecimal preco,
        @Schema(description = "Caminho da Imagem do Produto")
        String caminhoDaImagem
) {
    public ListagemProdutoDto(Produto produto) {
        this(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getCaminhoDaimagem()
        );
    }
}
