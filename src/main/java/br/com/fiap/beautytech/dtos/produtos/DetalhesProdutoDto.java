package br.com.fiap.beautytech.dtos.produtos;

import br.com.fiap.beautytech.models.Produto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DetalhesProdutoDto(
        Long id,
        String nome,
        String descricao,
        BigDecimal preco,
        LocalDate dataDeFabricacao,
        LocalDate validade,
        LocalDate dataDeCadastro,
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
