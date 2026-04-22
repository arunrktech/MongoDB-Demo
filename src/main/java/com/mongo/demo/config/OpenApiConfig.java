package com.mongo.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MongoDB Microservice API")
                        .version("1.0.0")
                        .description("Spring Boot + MongoDB REST API with Swagger UI")
                        .contact(new Contact()
                                .name("Your Name")
                                .email("your@email.com")));
    }
}