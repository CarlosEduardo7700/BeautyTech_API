package br.com.fiap.beautytech.models;

import br.com.fiap.beautytech.dtos.clientes.CadastroClienteDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy = "telefone", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cliente> clientes;

    public Telefone(CadastroClienteDto dto) {
        this.ddi = dto.ddiTelefone();
        this.ddd = dto.dddTelefone();
        this.numero = dto.numeroTelefone();
    }
}
