package br.com.fiap.beautytech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BT_PRODUTO_CATEGORIA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDeProduto {

    @Id
    @GeneratedValue
    @Column(name = "ID_PRODUTO_CATEGORIA")
    private Long id;

    @ManyToOne
    @JoinColumn(name="ID_PRODUTO", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name="ID_CATEGORIA", nullable = false)
    private Categoria categoria;
}
