package br.com.livrarialm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
=======
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
>>>>>>> parent of ebb4387... Correção de falhas e adição de relacionamento entre as entidades

@SpringBootApplication
public class LivrarialmApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrarialmApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}

}
