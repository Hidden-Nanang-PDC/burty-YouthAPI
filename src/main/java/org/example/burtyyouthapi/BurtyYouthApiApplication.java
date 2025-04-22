package org.example.burtyyouthapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
@OpenAPIDefinition(
        info = @Info(
                title       = "Burty Youth Policy API",
                version     = "v0.0.1",
                description = "청년정책 상세 검색 및 조회 API"
                //contact     = @Contact(name = "팀 Burty", email = "team@burty.example.com")
        )
)
@SpringBootApplication
public class BurtyYouthApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BurtyYouthApiApplication.class, args);
    }

}
