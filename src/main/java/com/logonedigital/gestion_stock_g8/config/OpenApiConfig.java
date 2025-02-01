package com.logonedigital.gestion_stock_g8.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "LOGONEDIGITAL TEKHUB ACADEMY",
                        email = "contact@logonedigital.com",
                        url = "https://logonedigital.com"
                ),
                title = "GESTION STOCK APIs",
                description = "Gestion Stock App APIs ",
                termsOfService = "&copy; LOGONEDIGITAL",
                version = "v1"
        )
)
public class OpenApiConfig {
}
