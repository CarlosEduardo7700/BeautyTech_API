package br.com.fiap.beautytech.dtos.generos;


import br.com.fiap.beautytech.models.Genero;

public record DetalhesDoGeneroDto(
        Long id,
        String nome,
        String descricao
) {
    public DetalhesDoGeneroDto(Genero genero) {
        this(
                genero.getId(),
                genero.getNome(),
                genero.getDescricao()
        );
    }
}
