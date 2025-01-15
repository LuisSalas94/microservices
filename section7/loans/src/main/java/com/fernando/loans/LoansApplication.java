package com.fernando.loans;

import com.fernando.loans.dto.LoansContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {LoansContactInfoDto.class})
@OpenAPIDefinition(
        info = @Info(
                title = "Loans microservice REST API Documentation",
                description = "Fernando Salas Loans microservice REST API Documentation",
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
                description = "Fernando Salas Loans microservice REST API Documentation",
                url = "www.google.com"
        )
)
public class LoansApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoansApplication.class, args);
    }

}
