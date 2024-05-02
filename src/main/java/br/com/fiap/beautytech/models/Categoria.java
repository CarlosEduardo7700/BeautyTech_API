package br.com.fiap.beautytech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "BT_CATEGORIA")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue
    @Column(name = "ID_CATEGORIA")
    private Long id;

    @Column(name = "NM_CATEGORIA", length = 50, nullable = false)
    private String nome;

    @Column(name = "DESC_CATEGORIA", length = 200, nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "categoria")
    private List<CategoriaDeProduto> categoriasDeProdutos;
}
