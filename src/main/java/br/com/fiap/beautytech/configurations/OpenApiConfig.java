package br.com.fiap.beautytech.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Suporte BeautyTech",
                        email = "suporte@beautytech.com.br"
                ),
                description = "Especificação da API do sistema da BeautyTech",
                title = "BeautyTech API"
        ),
        servers = {
                @Server(description = "Dev Env", url = "http://localhost:8080")
        }
)

public class OpenApiConfig {
}
