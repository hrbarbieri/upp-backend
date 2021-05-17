package br.com.petz.upp.config;

import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.parameters.RequestBody;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .openapi("3.0.3")
                .info(new Info()
                        .title("UPP API")
                        .description("Opt-in and opt-out control of the system's functionalities.")
                        .contact(new Contact()
                                .email("suporte@petz.com.br")
                                .name("Petz")
                                .url("http://www.petz.com.br")
                        )
                        .termsOfService("Termo do Serviço")
                        .license(new License().name("Nome da Licença").url("http://www.licenca.com.br"))
                        .version("1.0")
                );
    }
}