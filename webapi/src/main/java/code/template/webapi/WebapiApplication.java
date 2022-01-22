package code.template.webapi;

import java.beans.BeanProperty;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
@EnableWebMvc
public class WebapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebapiApplication.class, args);
    }

    @BeanProperty
    public Docket swaggerConfiguration() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis((RequestHandlerSelectors.basePackage("code.template")))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Code Template API",
                "API for Code Template",
                "1.0",
                "Terms of service",
                new springfox.documentation.service.Contact("admin", "http://localhost:8080", "nirin.suarod@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

}
