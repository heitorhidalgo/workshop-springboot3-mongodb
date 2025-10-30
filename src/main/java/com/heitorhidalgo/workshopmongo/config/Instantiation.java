package com.heitorhidalgo.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.heitorhidalgo.workshopmongo.domain.Post;
import com.heitorhidalgo.workshopmongo.domain.User;
import com.heitorhidalgo.workshopmongo.repository.PostRepository;
import com.heitorhidalgo.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userReposiroty;
	
	@Autowired
	private PostRepository postReposiroty;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userReposiroty.deleteAll();
		
		User tenma = new User(null, "Kenzo Tenma", "tenma@gmail.com");
		User johan = new User(null, "Johan Liebert", "johan@gmail.com");
		User anna = new User(null, "Anna Liebert", "anna@gmail.com");
		
		Post post1 = new Post(null, sdf.parse("30/10/2025"), "Em busca do Johan", "Estou procurando o Johan por toda a Alemanha.", tenma);
		Post post2 = new Post(null, sdf.parse("30/10/2025"), "Nao me recordo do passado", "Nao me lembro da minha infancia e do meu irmao Johan.", anna);

		userReposiroty.saveAll(Arrays.asList(tenma, johan, anna));
		postReposiroty.saveAll(Arrays.asList(post1, post2));
	}

}