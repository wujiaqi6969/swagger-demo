package com.jiaqi.wu.swaggerDemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author WJQ
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final boolean ENABLE = true;

    @Bean("getDocket")
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(ENABLE)
                .apiInfo(getApiInfo())
                .groupName("对外开放接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jiaqi.wu.swaggerDemo.controller"))
                .paths(PathSelectors.regex("/indexController/.*"))
                .build();
    }

    @Bean("otherDocket")
    public Docket getOtherDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(ENABLE)
                .apiInfo(getApiInfo())
                .groupName("另一个对外开发接口!!!")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jiaqi.wu.swaggerDemo.controller"))
                .paths(PathSelectors.regex("/otherController/.*"))
                .build();
    }


    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger-demo")
                .description("description")
                .contact(new Contact("佳奇", "jiaqi.url", "wujiaqi.@gmail.com"))
                .license("license")
                .version("1.0")
                .build();
    }

}
