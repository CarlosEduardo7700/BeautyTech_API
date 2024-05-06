package br.com.fiap.beautytech.dtos.clientes;

import br.com.fiap.beautytech.models.Cliente;
import br.com.fiap.beautytech.models.Genero;
import br.com.fiap.beautytech.models.Telefone;
import br.com.fiap.beautytech.models.enums.EstadoCivil;

import java.time.LocalDate;

public record DetalhesClienteDto(
        Long id,
        String cpf,
        String nome,
        String email,
        String senha,
        LocalDate dataDeNascimento,
        EstadoCivil estadoCivil,
        LocalDate dataDeCadastro,
        LocalDate dataDeExclusao,
        String nomeGenero,
        String ddiTelefone,
        Integer dddTelefone,
        String numeroTelefone
) {
    public DetalhesClienteDto(Cliente cliente) {
        this(
                cliente.getId(),
                cliente.getCpf(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getSenha(),
                cliente.getDataDeNascimento(),
                cliente.getEstadoCivil(),
                cliente.getDataDeCadastro(),
                cliente.getDataDeExclusao(),
                cliente.getGenero().getNome(),
                cliente.getTelefone().getDdi(),
                cliente.getTelefone().getDdd(),
                cliente.getTelefone().getNumero()
        );
    }
}
