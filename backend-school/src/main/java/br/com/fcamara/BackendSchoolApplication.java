package br.com.fcamara;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BackendSchoolApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder  configure(SpringApplicationBuilder application) {
		return application.sources(BackendSchoolApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(BackendSchoolApplication.class, args);
	}

}
