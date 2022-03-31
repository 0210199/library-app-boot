package com.ty.libraryappboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class LibraryAppBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryAppBootApplication.class, args);
	}
	@Bean
	public Docket getDocket() {
		Contact contact=new Contact("Library Management","www.digitallib.com","info@mail.com");
		List<VendorExtension> extensions=new ArrayList<VendorExtension>();
		ApiInfo apiinfo=new ApiInfo("Library Management API","Library Management Tool","SNPShot 1.0", "www.digitallib.com", contact, "Licence 456","www.lib.com", extensions);
		return new Docket(DocumentationType.SWAGGER_2)
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.ty.foodapp"))
		.build()
		.apiInfo(apiinfo)
		.useDefaultResponseMessages(false);
		
	}
}
