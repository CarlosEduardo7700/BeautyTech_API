package br.com.fiap.beautytech.models;

import br.com.fiap.beautytech.models.enums.EstadoCivil;
import br.com.fiap.beautytech.models.enums.Genero;
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

    @Column(name = "DT_NASCIMENTO", nullable = false)
    private LocalDate dataDeNascimento;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO_CIVIL", length = 30, nullable = false)
    private EstadoCivil estadoCivil;

    @Column(name = "GENERO", length = 30, nullable = false)
    private Genero genero;

    @CreatedDate
    @Column(name = "DT_CADASTRO", nullable = false)
    private LocalDate dataDeCadastro;

    @Column(name = "DT_EXCLUSAO")
    private LocalDate dataDeExclusao;
}
