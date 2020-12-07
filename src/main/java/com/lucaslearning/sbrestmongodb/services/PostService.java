package com.lucaslearning.sbrestmongodb.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaslearning.sbrestmongodb.domain.Post;
import com.lucaslearning.sbrestmongodb.repository.PostRepository;
import com.lucaslearning.sbrestmongodb.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired //injecao de dependencia automatica do spring
	private PostRepository rep;
	
	public Post findById(String id) {
		Optional<Post> user = rep.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		return rep.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000); //adicionar um dia a data maxima de procura
		return rep.fullSearch(text, minDate, maxDate);
	}
	
}
