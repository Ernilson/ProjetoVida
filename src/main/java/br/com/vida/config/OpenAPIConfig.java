package br.com.vida.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CADASTROS")
                        .description("API DE CADASTRO DE USUÁRIO")
                        .version("1.0.0"));
        
     // --> http://localhost:8080/swagger-ui/index.html
    }
}