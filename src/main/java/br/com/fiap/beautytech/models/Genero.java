package br.com.fiap.beautytech.models;

import br.com.fiap.beautytech.dtos.generos.AtualizarGeneroDto;
import br.com.fiap.beautytech.dtos.generos.CadastroDeGeneroDto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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

    @OneToMany(mappedBy = "genero", fetch = FetchType.LAZY)
    private List<Cliente> clientes;

    public Genero(CadastroDeGeneroDto dto) {
        this.nome = dto.nome();
        this.descricao = dto.descricao();
    }

    public void atualizarDados(AtualizarGeneroDto dto) {
        if (dto.nome() != null)
            this.nome = dto.nome();
        if (dto.descricao() != null)
            this.descricao = dto.descricao();
    }
}
