package com.study.jpa;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 설정을 담당하는 클래스
public class SwaggerConfig { // 스프링부트는 xml파일로 안만들고 클래스에서 만듬

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Spring boot Board API Example")
                        .description("Spring boot Board API 예시 프로젝트 입니다.")
                        .version("v1.0.0")
                );


    }
    
    
}
