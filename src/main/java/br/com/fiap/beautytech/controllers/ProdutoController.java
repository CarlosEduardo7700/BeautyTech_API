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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Produto", description = "Operações relacionadas aos Produtos da BeautyTech")
public class ProdutoController {

    @Autowired
    private ProdutosRepository repository;

    @PostMapping
    @Transactional
    @Operation(
            summary = "Cadastro de Produto",
            description = "Cadastra os dados de um Produto na aplicação"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Cadastro com Sucesso",
                    content = @Content(schema = @Schema(implementation = DetalhesProdutoDto.class), mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            )
    })
    public ResponseEntity<DetalhesProdutoDto> inserir(@RequestBody @Valid CadastroProdutoDto dto, UriComponentsBuilder uriBuilder) {
        Produto produto = new Produto(dto);
        repository.save(produto);

        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesProdutoDto(produto));
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Buscar um Produto pelo seu ID",
            description = "Recupera dados de um produto por meio de seu ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Busca realizada com Sucesso",
                    content = @Content(schema = @Schema(implementation = DetalhesClienteDto.class), mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Não Autorizado ou Token Inválido"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Nenhuma informação encontrada"
            )
    })
    @Parameters({
            @Parameter(
                    name = "id",
                    description = "Pesquisa o Produto por ID",
                    required = true,
                    in = ParameterIn.PATH,
                    example = "123",
                    schema = @Schema(type = "integer", format = "int64")
            )
    })
    public ResponseEntity<DetalhesProdutoDto> buscarPorId(@PathVariable("id") Long id) {
        var produto = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesProdutoDto(produto));
    }

    @GetMapping
    @Operation(
            summary = "Buscar todos os Produtos",
            description = "Recupera dados de todos os produtos já cadastrados"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Busca realizada com Sucesso",
                    content = @Content(schema = @Schema(implementation = DetalhesClienteDto.class), mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Não Autorizado ou Token Inválido"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Nenhuma informação encontrada"
            )
    })
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
    @Operation(
            summary = "Atualizar um Produto pelo seu ID",
            description = "Atualiza os dados de um produto por meio de seu ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Atualização realizada com Sucesso",
                    content = @Content(schema = @Schema(implementation = DetalhesClienteDto.class), mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Não Autorizado ou Token Inválido"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Nenhuma informação encontrada"
            )
    })
    @Parameters({
            @Parameter(
                    name = "id",
                    description = "Atualiza o Produto por ID",
                    required = true,
                    in = ParameterIn.PATH,
                    example = "123",
                    schema = @Schema(type = "integer", format = "int64")
            )
    })
    public ResponseEntity<DetalhesProdutoDto> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizarProdutoDto dto) {
        var produto = repository.getReferenceById(id);

        produto.atualizarDados(dto);

        return ResponseEntity.ok(new DetalhesProdutoDto(produto));
    }

    @DeleteMapping("{id}")
    @Transactional
    @Operation(
            summary = "Deletar um Produto pelo seu ID",
            description = "Deleta os dados de um produto por meio de seu ID"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Deleção realizada com Sucesso",
                    content = @Content(schema = @Schema(implementation = DetalhesClienteDto.class), mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Não Autorizado ou Token Inválido"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Nenhuma informação encontrada"
            )
    })
    @Parameters({
            @Parameter(
                    name = "id",
                    description = "Deleta o Produto por ID",
                    required = true,
                    in = ParameterIn.PATH,
                    example = "123",
                    schema = @Schema(type = "integer", format = "int64")
            )
    })
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
