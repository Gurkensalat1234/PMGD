package com.example.backend.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class BackendConfig {

    @Value("${swagger.documentation.title}")
    private String apiInfoTitle;

    @Value("${swagger.documentation.description}")
    private String apiInfoDescription;

    @Value("${swagger.documentation.version}")
    private String apiInfoVersion;

    @Bean
    public Docket swaggerConfiguration() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.backend.presenters"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
       return new ApiInfoBuilder()
                .title(apiInfoTitle)
                .description(apiInfoDescription)
                .version(apiInfoVersion)
               .build();
    }
}
