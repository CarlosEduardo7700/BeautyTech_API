package br.com.fiap.beautytech.dtos.clientes;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Informações do Token JWT")
public record TokenJwtDto(
        @Schema(description = "Token JWT")
        String tokenJwt
) {
}
