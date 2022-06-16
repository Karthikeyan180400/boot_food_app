package com.ty.bootfoodapp;

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
public class BootFoodAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootFoodAppApplication.class, args);
	}

	List<VendorExtension> vendorExtensions = new ArrayList<VendorExtension>();
	Contact contact = new Contact("vikas", "https://testyantra.com", "vikas@mail.com");

	ApiInfo apiInfo = new ApiInfo(
			"TestYantra Food App", 
			"API's to person all actions to book a food order",
			"Snapshoot-0.0.1",
			"Terms and Conditions",
			contact,
			"https:/testyantraglobal.com/",
			"www.ty.com",
			vendorExtensions);

	@Bean
	public Docket myDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ty"))
				.build()
				.apiInfo(apiInfo);

	}

}
