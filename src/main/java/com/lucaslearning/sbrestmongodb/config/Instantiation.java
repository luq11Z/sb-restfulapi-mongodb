package com.lucaslearning.sbrestmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucaslearning.sbrestmongodb.domain.User;
import com.lucaslearning.sbrestmongodb.repository.UserRepository;

@Configuration //anotacao necessari para o spring entender que e uma configuracao
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRep;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRep.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRep.saveAll(Arrays.asList(maria,alex,bob));
		
	}

}
