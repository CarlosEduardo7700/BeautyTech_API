package br.com.fiap.beautytech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BT_EMPRESA_PRODUTO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDaEmpresa {
    @Id
    @GeneratedValue
    @Column(name = "ID_EMPRESA_PRODUTO")
    private Long id;

    @ManyToOne
    @JoinColumn(name="ID_PRODUTO", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name="ID_EMPRESA", nullable = false)
    private Empresa empresa;
}
