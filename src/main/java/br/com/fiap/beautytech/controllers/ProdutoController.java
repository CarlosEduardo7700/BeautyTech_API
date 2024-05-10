package br.com.fiap.beautytech.controllers;

import br.com.fiap.beautytech.dtos.clientes.AtualizarClienteDto;
import br.com.fiap.beautytech.dtos.clientes.CadastroClienteDto;
import br.com.fiap.beautytech.dtos.clientes.DetalhesClienteDto;
import br.com.fiap.beautytech.dtos.clientes.ListagemClienteDto;
import br.com.fiap.beautytech.dtos.produtos.AtualizarProdutoDto;
import br.com.fiap.beautytech.dtos.produtos.CadastroProdutoDto;
import br.com.fiap.beautytech.dtos.produtos.DetalhesProdutoDto;
import br.com.fiap.beautytech.dtos.produtos.ListagemProdutoDto;
import br.com.fiap.beautytech.models.Cliente;
import br.com.fiap.beautytech.models.Genero;
import br.com.fiap.beautytech.models.Produto;
import br.com.fiap.beautytech.models.Telefone;
import br.com.fiap.beautytech.repositories.ProdutosRepository;
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
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutosRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesProdutoDto> inserir(@RequestBody @Valid CadastroProdutoDto dto, UriComponentsBuilder uriBuilder) {
        Produto produto = new Produto(dto);
        repository.save(produto);

        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesProdutoDto(produto));
    }

    @GetMapping("{id}")
    public ResponseEntity<DetalhesProdutoDto> buscarPorId(@PathVariable("id") Long id) {
        var produto = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesProdutoDto(produto));
    }

    @GetMapping
    public ResponseEntity<List<ListagemProdutoDto>> buscarTudo(Pageable pageable) {
        var listaDto = repository.findAll(pageable)
                .stream().map(ListagemProdutoDto::new).toList();

        if (!listaDto.isEmpty())
            return ResponseEntity.ok(listaDto);
        else
            return ResponseEntity.notFound().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhesProdutoDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizarProdutoDto dto) {
        var produto = repository.getReferenceById(id);

        produto.atualizarDados(dto);

        return ResponseEntity.ok(new DetalhesProdutoDto(produto));
    }
}
