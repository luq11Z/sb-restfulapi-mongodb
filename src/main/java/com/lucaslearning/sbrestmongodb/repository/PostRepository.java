package com.lucaslearning.sbrestmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucaslearning.sbrestmongodb.domain.Post;

//a partir disso e possivel realizar operacoes em base de dados para essa classe
@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}
