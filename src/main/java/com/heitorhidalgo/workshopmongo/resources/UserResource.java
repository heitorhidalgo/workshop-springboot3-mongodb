package com.heitorhidalgo.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heitorhidalgo.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		User tenma = new User("1", "Kenzo Tenma", "tenma@gmail.com");
		User johan = new User("2", "Johan Liebert", "johan@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(tenma, johan));
		return ResponseEntity.ok().body(list);
	}

}
