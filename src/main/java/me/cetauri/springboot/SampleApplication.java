package me.cetauri.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource("classpath:/app.properties")
public class SampleApplication {

	public static void main(String[] args) {

//		SpringApplication application = new SpringApplication(SampleApplication.class);
//		application.setWebApplicationType(WebApplicationType.NONE);
//		application.run(args);


		SpringApplication.run(SampleApplication.class, args);
	}

}
