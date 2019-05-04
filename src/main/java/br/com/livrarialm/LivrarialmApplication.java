package br.com.livrarialm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"br.com.livrarialm"})
@EnableAutoConfiguration
public class LivrarialmApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrarialmApplication.class, args);
	}

}
