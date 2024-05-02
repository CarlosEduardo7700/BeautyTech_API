package br.com.fiap.beautytech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BT_ENDERECO")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue
    @Column(name = "ID_ENDERECO")
    private Long id;

    @Column(name = "LOGRADOURO_ENDERECO", length = 150, nullable = false)
    private String logradouro;

    @Column(name = "NR_ENDERECO", nullable = false)
    private Integer numero;

    @Column(name = "BAIRRO_ENDERECO", length = 50, nullable = false)
    private String bairro;

    @Column(name = "COMPLEMENTO_ENDERECO", length = 50)
    private String complemento;

    @ManyToOne
    @JoinColumn(name="ID_EMPRESA", nullable = false)
    private Empresa empresa;
}
