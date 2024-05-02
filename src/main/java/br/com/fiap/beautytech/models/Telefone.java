package br.com.fiap.beautytech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BT_TELEFONE")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Telefone {
    @Id
    @GeneratedValue
    @Column(name = "ID_TELEFONE")
    private Long id;

    @Column(name = "DDI_TELEFONE", length = 3, nullable = false)
    private String ddi;

    @Column(name = "DDD_TELEFONE", nullable = false)
    private Integer ddd;

    @Column(name = "NR_TELEFONE", length = 9, nullable = false)
    private String numero;
}
