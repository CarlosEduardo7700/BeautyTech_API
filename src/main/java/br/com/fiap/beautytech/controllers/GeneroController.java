package br.com.fiap.beautytech.controllers;

import br.com.fiap.beautytech.dtos.clientes.AtualizarClienteDto;
import br.com.fiap.beautytech.dtos.clientes.DetalhesClienteDto;
import br.com.fiap.beautytech.dtos.clientes.ListagemClienteDto;
import br.com.fiap.beautytech.dtos.generos.AtualizarGeneroDto;
import br.com.fiap.beautytech.dtos.generos.CadastroDeGeneroDto;
import br.com.fiap.beautytech.dtos.generos.DetalhesDoGeneroDto;
import br.com.fiap.beautytech.dtos.generos.ListagemDeGenerosDto;
import br.com.fiap.beautytech.models.Genero;
import br.com.fiap.beautytech.repositories.GeneroRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("generos")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesDoGeneroDto> inserir(@RequestBody @Valid CadastroDeGeneroDto dto, UriComponentsBuilder uriBuilder) {
        Genero genero = new Genero(dto);
        generoRepository.save(genero);

        URI uri = uriBuilder.path("/generos/{id}").buildAndExpand(genero.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesDoGeneroDto(genero));
    }

    @GetMapping
    public ResponseEntity<List<ListagemDeGenerosDto>> buscarTudo(Pageable pageable) {

        var listaDto = generoRepository.findAll(pageable)
                .stream().map(ListagemDeGenerosDto::new).toList();

        if (!listaDto.isEmpty())
            return ResponseEntity.ok(listaDto);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesDoGeneroDto> buscarPorId(@PathVariable("id") Long id) {
        var genero = generoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesDoGeneroDto(genero));
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesDoGeneroDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizarGeneroDto dto) {
        var genero = generoRepository.getReferenceById(id);

        genero.atualizarDados(dto);

        return ResponseEntity.ok(new DetalhesDoGeneroDto(genero));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        generoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
