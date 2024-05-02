package br.com.fiap.beautytech.models;

import br.com.fiap.beautytech.dtos.AtualizarClienteDto;
import br.com.fiap.beautytech.dtos.CadastroClienteDto;
import br.com.fiap.beautytech.models.enums.EstadoCivil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Entity
@Table(name = "BT_CLIENTE")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Cliente {

    @Id
    @GeneratedValue
    @Column(name = "ID_CLIENTE")
    private Long id;

    @Column(name = "CPF_CLIENTE", length = 11, nullable = false)
    private String cpf;

    @Column(name = "NM_CLIENTE", length = 150, nullable = false)
    private String nome;

    @Column(name = "EMAIL_CLIENTE", length = 100)
    private String email;

    @Column(name = "DT_NASCIMENTO_CLIENTE", nullable = false)
    private LocalDate dataDeNascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO_CIVIL_CLIENTE", length = 30, nullable = false)
    private EstadoCivil estadoCivil;

    @CreatedDate
    @Column(name = "DT_CADASTRO", nullable = false)
    private LocalDate dataDeCadastro;

    @Column(name = "DT_EXCLUSAO")
    private LocalDate dataDeExclusao;

    public Cliente(CadastroClienteDto dto) {
        this.cpf = dto.cpf();
        this.nome = dto.nome();
        this.email = dto.email();
        this.dataDeNascimento = dto.dataDeNascimento();
        this.estadoCivil = dto.estadoCivil();
    }

    public void atualizarDados(AtualizarClienteDto dto) {
        if (dto.cpf() != null)
            this.cpf = dto.cpf();
        if (dto.nome() != null)
            this.nome = dto.nome();
        if (dto.email() != null)
            this.email = dto.email();
        if (dto.dataDeNascimento() != null)
            this.dataDeNascimento = dto.dataDeNascimento();
        if (dto.estadoCivil() != null)
            this.estadoCivil = dto.estadoCivil();
        if (dto.dataDeExclusao() != null)
            this.dataDeExclusao = dto.dataDeExclusao();
    }
}
