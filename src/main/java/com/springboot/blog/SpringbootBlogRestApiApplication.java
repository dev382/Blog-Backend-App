package com.springboot.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootBlogRestApiApplication  {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBlogRestApiApplication.class, args);
	}

	// To create the USER and ADMIN Roles in your MysQL database, uncomment this code block when running the
	// app for the first time (comment it out again before subsequent runs to avoid creating duplicate roles) and make
	// sure the SpringbootBlogRestApiApplication class implements CommandLineRunner from the spring framework:

//	@Autowired
//	private RoleRepository roleRepository;
//
//	@Override
//	public void run(String... args) throws Exception {
//
//		Role adminRole = new Role();
//		adminRole.setName("ROLE_ADMIN");
//		roleRepository.save(adminRole);
//
//		Role userRole = new Role();
//		userRole.setName("ROLE_USER");
//		roleRepository.save(userRole);
//
//	}

}
