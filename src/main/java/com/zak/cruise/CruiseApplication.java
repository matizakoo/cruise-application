package com.zak.cruise;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

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
//	@Bean
//	CommandLineRunner commandLineRunner(TempRepository tempRepository){
//		return args -> {
//			TempUser tempUser = new TempUser("czy dziala");
//			Logger logger = LoggerFactory.getLogger("log to");
//			logger.info("git");
//			tempRepository.save(tempUser);
//		};
//	}
	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
}
}
