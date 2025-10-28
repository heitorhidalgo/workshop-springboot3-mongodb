package com.heitorhidalgo.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.heitorhidalgo.workshopmongo.domain.User;
import com.heitorhidalgo.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userReposiroty;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		userReposiroty.deleteAll();
		
		User tenma = new User(null, "Kenzo Tenma", "tenma@gmail.com");
		User johan = new User(null, "Johan Liebert", "johan@gmail.com");
		User anna = new User(null, "Anna Liebert", "anna@gmail.com");

		userReposiroty.saveAll(Arrays.asList(tenma, johan, anna));
	}

}