package br.com.fiap.beautytech.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BT_ENDERECO_CLIENTE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDoCliente {

    @Id
    @GeneratedValue
    @Column(name = "ID_ENDERECO_CLIENTE")
    private Long id;

    @ManyToOne
    @JoinColumn(name="ID_ENDERECO", nullable = false)
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name="ID_CLIENTE", nullable = false)
    private Cliente cliente;
}
