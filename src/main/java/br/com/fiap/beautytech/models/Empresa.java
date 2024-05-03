package br.com.fiap.beautytech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "BT_EMPRESA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue
    @Column(name = "ID_EMPRESA")
    private Long id;

    @Column(name = "NM_EMPRESA", length = 50, nullable = false)
    private String nome;

    @Column(name = "CNPJ_EMPRESA", length = 18, nullable = false)
    private String cnpj;

    @Column(name = "DESC_EMPRESA", length = 300, nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "empresa")
    private List<Endereco> enderecos;

    @OneToMany(mappedBy = "empresa")
    private List<ProdutoDaEmpresa> produtosDaEmpresa;
}
