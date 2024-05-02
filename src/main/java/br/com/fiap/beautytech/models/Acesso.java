package br.com.fiap.beautytech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BT_ACESSO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Acesso {

    @Id
    @GeneratedValue
    @Column(name = "ID_ACESSO")
    private Long id;

    @ManyToOne
    @JoinColumn(name="ID_PRODUTO", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name="ID_CLIENTE", nullable = false)
    private Cliente cliente;
}
