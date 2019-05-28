package br.com.livrarialm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class LivrarialmApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivrarialmApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("123456"));
	}

}
