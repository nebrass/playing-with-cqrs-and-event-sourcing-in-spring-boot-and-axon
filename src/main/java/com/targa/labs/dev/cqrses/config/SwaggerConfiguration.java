package com.targa.labs.dev.cqrses.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.targa.labs.dev.cqrses"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "CQRS & ES Sample App based on Spring Boot and Axon",
                "App to demonstrate CQRS & ES based on Spring Boot and Axon",
                "0.0.1-SNAPSHOT",
                "Terms of Service",
                new Contact("Nebrass Lamouchi",
                        "https://blog.nebrass.fr",
                        "lnibrass@gmail.com"),
                "",
                "",
                Collections.emptyList());
    }
}
