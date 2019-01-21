package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ImportResource("classpath:Beans.xml")

@Controller
@RequestMapping("/home")

public class ChaussoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ChaussoApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ChaussoApplication.class);
	}
	
	@GetMapping
	public String getArticle() {
		
		 return "forward:/index.html";

	}

}

