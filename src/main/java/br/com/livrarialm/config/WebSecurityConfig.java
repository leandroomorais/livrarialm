package br.com.livrarialm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private ImplementsUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()

		.antMatchers("/categoria/**").hasAnyAuthority("ADMIN")
		.antMatchers("/administrador/**").hasAnyAuthority("ADMIN")
		.antMatchers("/livro/**").hasAnyAuthority("ADMIN")
		.antMatchers("/editora/**").hasAnyAuthority("ADMIN")
		.antMatchers("/pedido/**").hasAnyAuthority("ADMIN", "USER")
		.antMatchers("/usuario/add**").permitAll()
		.antMatchers("/usuario/**").permitAll()
		.antMatchers("/item-pedido/**").hasAnyAuthority("ADMIN", "USER")
		.anyRequest().authenticated().and().formLogin().loginPage("/entrar").permitAll()
		.successForwardUrl("/").and().logout().permitAll()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/entrar");
		http.csrf().disable();
		http.headers().frameOptions().disable();
		http.headers().frameOptions().disable();
	}
	
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(userDetailsService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(WebSecurity webSecurity) throws Exception{
		webSecurity.ignoring().antMatchers("/resources/**", "/css/**", "/img/**",  "/js/**",  "/fonts/**", "/h2/**", "/static/**", "/templates/**");
		webSecurity.ignoring().antMatchers("http::/**", "https::/**", "/http::/**", "/https::/**");
	}
	

}
