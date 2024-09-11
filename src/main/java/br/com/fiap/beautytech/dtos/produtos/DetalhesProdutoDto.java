package br.com.fiap.beautytech.dtos.produtos;

import br.com.fiap.beautytech.models.Produto;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.LocalDate;

@Schema(description = "Informações de um Produto")
public record DetalhesProdutoDto(
        @Schema(description = "ID do Produto")
        Long id,
        @Schema(description = "Nome do Produto")
        String nome,
        @Schema(description = "Descrição do Produto")
        String descricao,
        @Schema(description = "Preço do Produto")
        BigDecimal preco,
        @Schema(description = "Data de Fabricação do Produto")
        LocalDate dataDeFabricacao,
        @Schema(description = "Validade do Produto")
        LocalDate validade,
        @Schema(description = "Data de Cadastro do Produto")
        LocalDate dataDeCadastro,
        @Schema(description = "Caminho da Imagem do Produto")
        String caminhoDaImagem
) {
    public DetalhesProdutoDto(Produto produto) {
        this(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getDataDeFabricacao(),
                produto.getValidade(),
                produto.getDataDeCadastro(),
                produto.getCaminhoDaimagem()
        );
    }
}
