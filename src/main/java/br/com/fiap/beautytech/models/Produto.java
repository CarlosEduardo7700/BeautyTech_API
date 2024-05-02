package br.com.fiap.beautytech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "BT_PRODUTO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name = "NM_PRODUTO", length = 150, nullable = false)
    private String nome;

    @Column(name = "DESC_PRODUTO", length = 150, nullable = false)
    private String descricao;

    @Column(name = "VL_PRODUTO", precision = 8, scale = 2, nullable = false)
    private BigDecimal preco;

    @Column(name = "DT_FAB_PRODUTO", nullable = false)
    private LocalDate dataDeFabricacao;

    @Column(name = "DT_VALIDADE", nullable = false)
    private LocalDate validade;

    @Column(name = "DT_CADASTRO", nullable = false)
    private LocalDate dataDeCadastro;

    @Column(name = "IMG_PRODUTO", length = 300, nullable = false)
    private String caminhoDaimagem;

    @OneToMany(mappedBy = "produto")
    private List<Acesso> acessos;

    @OneToMany(mappedBy = "produto")
    private List<CategoriaDeProduto> categoriasDeProdutos;
}
