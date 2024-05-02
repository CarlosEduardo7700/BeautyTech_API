package br.com.fiap.beautytech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "BT_GENERO")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Genero {
    @Id
    @GeneratedValue
    @Column(name = "ID_GENERO")
    private Long id;

    @Column(name = "NM_GENERO", length = 50, nullable = false)
    private String nome;

    @Column(name = "DESC_GENERO", length = 100, nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "genero")
    private List<Cliente> clientes;
}
