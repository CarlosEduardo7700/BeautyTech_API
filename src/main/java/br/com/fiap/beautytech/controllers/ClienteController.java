package br.com.fiap.beautytech.controllers;

import br.com.fiap.beautytech.dtos.CadastroClienteDto;
import br.com.fiap.beautytech.dtos.DetalhesClienteDto;
import br.com.fiap.beautytech.models.Cliente;
import br.com.fiap.beautytech.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesClienteDto> inserir(@RequestBody CadastroClienteDto dto, UriComponentsBuilder uriBuilder) {
        Cliente cliente = new Cliente(dto);
        repository.save(cliente);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesClienteDto(cliente));
    }
}
