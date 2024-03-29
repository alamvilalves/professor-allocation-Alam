package com.project.professor.allocation.alam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.project.professor.allocation.alam.ProfessorAllocationAlamApplication;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors
						.basePackage(ProfessorAllocationAlamApplication.class.getPackage().getName()))
				.paths(PathSelectors.any()).build().useDefaultResponseMessages(false).apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("Professor Allocation")
				.description("Professor Allocation - Alam VilalvesRest Server").version("0.0.1-SNAPSHOT").build();
	}

}