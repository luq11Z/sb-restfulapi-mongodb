package com.lucaslearning.sbrestmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lucaslearning.sbrestmongodb.domain.Post;
import com.lucaslearning.sbrestmongodb.domain.User;
import com.lucaslearning.sbrestmongodb.dto.AuthorDTO;
import com.lucaslearning.sbrestmongodb.repository.PostRepository;
import com.lucaslearning.sbrestmongodb.repository.UserRepository;

@Configuration //anotacao necessari para o spring entender que e uma configuracao
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRep;
	
	@Autowired
	private PostRepository postRep;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRep.deleteAll();
		postRep.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		userRep.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Bom dia", "Acordei feliz hoje", new AuthorDTO(maria));
		postRep.saveAll(Arrays.asList(post1,post2));
	}

}
