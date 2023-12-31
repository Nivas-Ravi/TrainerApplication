package com.example.trainer.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info =@Info(
				title="Trainer Application",
				version="1.0.0",
				description="API checking for Trainer Application!",
				termsOfService="runcodenow",
				contact=@Contact(
						name="Mr Nivas",
						email="nivas.ms@capestart.com"),
				license=@License(
						
						name="licence",
						url="runcodenow")
				)
//				servers = @Server(url = "/api/user")
		)
@SecurityScheme(
		name="bearerAuth",
		description="JWT auth description",
		scheme="bearer",
		type=SecuritySchemeType.HTTP,
		bearerFormat="JWT",
		in=SecuritySchemeIn.HEADER
		)
@Configuration
public class OpenApiConfig{
	
	@Bean
	public GroupedOpenApi authenticationApi() {
		String[]  paths= {"/api/user/**"};
		return GroupedOpenApi.builder()
				.group("Authentication")
				.pathsToMatch(paths)
				.build();
	}
}

