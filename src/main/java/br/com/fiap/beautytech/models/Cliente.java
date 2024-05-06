package br.com.fiap.beautytech.models;

import br.com.fiap.beautytech.dtos.clientes.AtualizarClienteDto;
import br.com.fiap.beautytech.dtos.clientes.CadastroClienteDto;
import br.com.fiap.beautytech.models.enums.EstadoCivil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.List;

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

    @Column(name = "EMAIL_CLIENTE", length = 100, nullable = false)
    private String email;

    @Column(name = "SENHA_CLIENTE", length = 50, nullable = false)
    private String senha;

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

    @ManyToOne
    @JoinColumn(name="ID_GENERO", nullable = false)
    private Genero genero;

    @ManyToOne
    @JoinColumn(name="ID_TELEFONE", nullable = false)
    private Telefone telefone;

    @OneToMany(mappedBy = "cliente")
    private List<Acesso> acessos;

    @OneToMany(mappedBy = "cliente")
    private List<EnderecoDoCliente> enderecosDoCliente;

    public Cliente(CadastroClienteDto dto, Genero genero, Telefone telefone) {
        this.cpf = dto.cpf();
        this.nome = dto.nome();
        this.email = dto.email();
        this.senha = dto.senha();
        this.dataDeNascimento = dto.dataDeNascimento();
        this.estadoCivil = dto.estadoCivil();
        this.genero = genero;
        this.telefone = telefone;
    }

    public void atualizarDados(AtualizarClienteDto dto, Genero genero, Telefone telefone) {
        if (dto.cpf() != null)
            this.cpf = dto.cpf();
        if (dto.nome() != null)
            this.nome = dto.nome();
        if (dto.email() != null)
            this.email = dto.email();
        if (dto.senha() != null)
            this.senha = dto.senha();
        if (dto.dataDeNascimento() != null)
            this.dataDeNascimento = dto.dataDeNascimento();
        if (dto.estadoCivil() != null)
            this.estadoCivil = dto.estadoCivil();
        if (dto.dataDeExclusao() != null)
            this.dataDeExclusao = dto.dataDeExclusao();
        if (genero != null)
            this.genero = genero;
        if (telefone != null)
            this.telefone = telefone;
    }
}
