package com.westpac.jsonplaceholderSpringbootapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@SuppressWarnings("deprecation")
@EnableSwagger2
@Configuration
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurerAdapter {

    @Value("${api.version}")
    private String version;

    @Bean
    public Docket thirdPartyAPI(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.westpac.jsonplaceholderSpringbootapp"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "JSON Placeholder Spring boot App APIs",
                "Third Party API",
                version,
                "https://www.westpac.co.nz/who-we-are/about-westpac-new-zealand/westpac-legal-information/#tab2",
                new Contact("JSON Placeholder Spring boot App", "https://www.westpac.co.nz/", "himanshu.vashistha54@gmail.com"),
                null, null, Collections.emptyList());
    }

    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("classpath:/templates/");        
    }
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
