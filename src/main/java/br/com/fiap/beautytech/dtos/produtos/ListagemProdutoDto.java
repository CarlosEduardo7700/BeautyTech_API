package br.com.fiap.beautytech.dtos.produtos;

import br.com.fiap.beautytech.models.Produto;

import java.math.BigDecimal;

public record ListagemProdutoDto(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
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
