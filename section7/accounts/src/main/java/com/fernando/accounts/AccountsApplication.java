package com.fernando.accounts;

import com.fernando.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts Microservice REST API Documentation",
                description = "Accounts Microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Fernando Salas",
                        email = "luis@gmail.com",
                        url = "www.google.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "www.google.com"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Accounts Microservice REST API Documentation",
                url = "www.google.com"
        )
)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
