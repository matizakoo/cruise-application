package com.zak.cruise;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zak.cruise.config.RestAuthenticationSuccessHandler;
import com.zak.cruise.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class CruiseApplication {
	public static void main(String[] args) {
		SpringApplication.run(CruiseApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

//	@Bean
//	public DelegatingPasswordEncoder delegatingPasswordEncoder() {
//		PasswordEncoder defaultEncoder = new StandardPasswordEncoder();
//		Map<String, PasswordEncoder> encoders = new HashMap<>();
//		encoders.put("bcrypt", new BCryptPasswordEncoder());
//		encoders.put("scrypt", new SCryptPasswordEncoder());
//
//		DelegatingPasswordEncoder passworEncoder = new DelegatingPasswordEncoder(
//				"bcrypt", encoders);
//		passworEncoder.setDefaultPasswordEncoderForMatches(defaultEncoder);
//
//		return passworEncoder;
//	}

	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
}

	@Bean
	public ObjectMapper objectMapper(){
		return new ObjectMapper();
	}
}
