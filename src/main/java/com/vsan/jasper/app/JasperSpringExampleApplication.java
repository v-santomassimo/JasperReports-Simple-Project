package com.vsan.jasper.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JasperSpringExampleApplication {
	
	/**
	 * In Spring Boot, when you try to create a Swing frame from the component that is the entry point of your app, you will get:
		Caused by: java.awt.HeadlessException.
		
		To solve this, in your Application class in main, instead of:

			1 SpringApplication.run (Application.class, args);
			
		use
			1 SpringApplicationBuilder builder = new SpringApplicationBuilder(Application.class);
			2 builder.headless(false);
			3 ConfigurableApplicationContext context = builder.run(args);
	 * */

	public static void main(String[] args) {
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(JasperSpringExampleApplication.class);
		builder.headless(false);
		ConfigurableApplicationContext context = builder.run(args);
//		SpringApplication.run(JasperSpringExampleApplication.class, args);
	}

}
