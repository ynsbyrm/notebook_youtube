package com.yunusemre.notebook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableWebMvc
public class SpringFoxConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.yunusemre.notebook"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("Springboot ile Swagger Uygulama")
                .description("Kullanıcılar için API Dökümanı")
                .contact(new Contact("Yunus Emre BAYRAM", "www.yunusemrebayram.com", "deneme123@hotmail.com"))
                .license("Apache 2.0")
                .licenseUrl("aslında yok.com")
                .version("0.0.1-SNAPSHOT")
                .build();
    }
}
