package br.com.fiap.beautytech.controllers;

import br.com.fiap.beautytech.dtos.clientes.*;
import br.com.fiap.beautytech.models.Cliente;
import br.com.fiap.beautytech.models.Genero;
import br.com.fiap.beautytech.models.Telefone;
import br.com.fiap.beautytech.repositories.ClienteRepository;
import br.com.fiap.beautytech.repositories.GeneroRepository;
import br.com.fiap.beautytech.repositories.TelefoneRepository;
import br.com.fiap.beautytech.service.TokenService;
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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("clientes")
@Tag(name = "Cliente", description = "Operações relacionadas aos Clientes (Usuários) da BeautyTech")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("login")
    @Operation(
            summary = "Login do Cliente",
            description = "Permite que o usuário insira seus dados para realiar o login na aplicação"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Login feito com Sucesso",
                    content = @Content(schema = @Schema(implementation = DetalhesClienteDto.class), mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            )
    })
    public ResponseEntity<TokenJwtDto> login(@RequestBody @Valid LoginClienteDto dto) {
        var token = new UsernamePasswordAuthenticationToken(dto.email(), dto.senha());

        var authentication = manager.authenticate(token);

        System.out.println(authentication);
        var tokenJwt = tokenService.gerarToken((Cliente) authentication.getPrincipal());
        System.out.println(tokenJwt);
        return ResponseEntity.ok(new TokenJwtDto(tokenJwt));
    }

    @PostMapping
    @Transactional
    @Operation(
            summary = "Cadastro do Cliente",
            description = "Permite que o usuário insira seus dados para realiar seu cadastro na aplicação"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Cadastro com Sucesso",
                    content = @Content(schema = @Schema(implementation = DetalhesClienteDto.class), mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos"
            )
    })
    public ResponseEntity<DetalhesClienteDto> inserir(@RequestBody @Valid CadastroClienteDto dto, UriComponentsBuilder uriBuilder) {

        Telefone telefone = new Telefone(dto);
        telefoneRepository.save(telefone);

        Cliente cliente = new Cliente(dto,
                generoRepository.getReferenceById(dto.idGenero()),
                telefone, passwordEncoder);

        repository.save(cliente);

        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhesClienteDto(cliente));
    }

    @GetMapping
    @Operation(
            summary = "Buscar todos os Cliente",
            description = "Recupera dados de todos os clientes já cadastrados"
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
    public ResponseEntity<List<ListagemClienteDto>> buscarTudo(Pageable pageable) {

        var listaDto = repository.findAll(pageable)
                .stream().map(ListagemClienteDto::new).toList();

        if (!listaDto.isEmpty())
            return ResponseEntity.ok(listaDto);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Buscar um Cliente pelo seu ID",
            description = "Recupera dados de um cliente por meio de seu ID"
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
                    description = "Pesquisa o Cliente por ID",
                    required = true,
                    in = ParameterIn.PATH,
                    example = "123",
                    schema = @Schema(type = "integer", format = "int64")
            )
    })
    public ResponseEntity<DetalhesClienteDto> buscarPorId(@PathVariable("id") Long id) {
        var cliente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhesClienteDto(cliente));
    }

    @PutMapping("{id}")
    @Transactional
    @Operation(
            summary = "Atualizar um Cliente pelo seu ID",
            description = "Atualiza os dados de um cliente por meio de seu ID"
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
                    description = "Atualiza o Cliente por ID",
                    required = true,
                    in = ParameterIn.PATH,
                    example = "123",
                    schema = @Schema(type = "integer", format = "int64")
            )
    })
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
    @Operation(
            summary = "Deletar um Cliente pelo seu ID",
            description = "Deleta os dados de um cliente por meio de seu ID"
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
                    description = "Deleta o Cliente por ID",
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
