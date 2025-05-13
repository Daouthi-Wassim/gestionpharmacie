package com.gestion.pharmacie.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "API Gestion Pharmacie",
                version = "1.0",
                description = "API pour la gestion des médicaments, catégories et fournisseurs",
                contact = @Contact(
                        name = "Votre équipe",
                        email = "contact@pharmacie.com"
                ),
                license = @License(
                        name = "MIT License",
                        url = "https://opensource.org/licenses/MIT"
                )
        )
)

 */
public class SwaggerConfig {
/*
    @Bean
    public GroupedOpenApi medicamentsApi() {
        return GroupedOpenApi.builder()
                .group("Médicaments")
                .pathsToMatch("/api/medicaments/**")
                .build();
    }

    @Bean
    public GroupedOpenApi categoriesApi() {
        return GroupedOpenApi.builder()
                .group("Catégories")
                .pathsToMatch("/api/categories/**")
                .build();
    }

    @Bean
    public GroupedOpenApi fournisseursApi() {
        return GroupedOpenApi.builder()
                .group("Fournisseurs")
                .pathsToMatch("/api/fournisseurs/**")
                .build();
    }

 */
}