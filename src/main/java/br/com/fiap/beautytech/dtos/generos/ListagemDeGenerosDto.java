package br.com.fiap.beautytech.dtos.generos;

import br.com.fiap.beautytech.models.Genero;

public record ListagemDeGenerosDto(
        Long id,
        String nome,
        String descricao
) {
    public ListagemDeGenerosDto(Genero genero) {
        this(
                genero.getId(),
                genero.getNome(),
                genero.getDescricao()
        );
    }
}
