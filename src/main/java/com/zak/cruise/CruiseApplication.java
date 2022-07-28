package com.zak.cruise;

import com.zak.cruise.entity.TempUser;
import com.zak.cruise.repository.TempRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CruiseApplication {
	public static void main(String[] args) {
		SpringApplication.run(CruiseApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner commandLineRunner(TempRepository tempRepository){
		return args -> {
			TempUser tempUser = new TempUser("Matixon");
			Logger logger = LoggerFactory.getLogger("log to");
			logger.info("git");
			tempRepository.save(tempUser);
		};
	}
}
