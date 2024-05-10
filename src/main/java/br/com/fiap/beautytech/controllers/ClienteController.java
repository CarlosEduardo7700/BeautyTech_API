package br.com.fiap.beautytech.controllers;

import br.com.fiap.beautytech.dtos.clientes.*;
import br.com.fiap.beautytech.models.Cliente;
import br.com.fiap.beautytech.models.Genero;
import br.com.fiap.beautytech.models.Telefone;
import br.com.fiap.beautytech.repositories.ClienteRepository;
import br.com.fiap.beautytech.repositories.GeneroRepository;
import br.com.fiap.beautytech.repositories.TelefoneRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @PostMapping("login")
    public ResponseEntity<DetalhesClienteDto> login(@RequestBody LoginClienteDto dto) {
        var usuarioProcurado = repository.findByEmailAndSenha(dto.email(), dto.senha());
        Cliente cliente;
        if (usuarioProcurado.isEmpty())
            return ResponseEntity.notFound().build();
        else {
            cliente = usuarioProcurado.get();
            return ResponseEntity.ok(new DetalhesClienteDto(cliente));
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesClienteDto> inserir(@RequestBody @Valid CadastroClienteDto dto, UriComponentsBuilder uriBuilder) {

        Telefone telefone = new Telefone(dto);
        telefoneRepository.save(telefone);

        Cliente cliente = new Cliente(dto,
                generoRepository.getReferenceById(dto.idGenero()),
                telefone);
        repository.save(cliente);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesClienteDto(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ListagemClienteDto>> buscarTudo(Pageable pageable) {

        var listaDto = repository.findAll(pageable)
                .stream().map(ListagemClienteDto::new).toList();

        if (!listaDto.isEmpty())
            return ResponseEntity.ok(listaDto);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesClienteDto> buscarPorId(@PathVariable("id") Long id) {
        var cliente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesClienteDto(cliente));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesClienteDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizarClienteDto dto) {
        var cliente = repository.getReferenceById(id);
        Genero genero = null;

        if (dto.idGenero() != null)
            genero = generoRepository.getReferenceById(dto.idGenero());

        cliente.atualizarDados(dto, genero);

        return ResponseEntity.ok(new DetalhesClienteDto(cliente));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
