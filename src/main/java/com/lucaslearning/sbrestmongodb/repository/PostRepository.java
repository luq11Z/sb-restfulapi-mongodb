package com.lucaslearning.sbrestmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.lucaslearning.sbrestmongodb.domain.Post;

//a partir disso e possivel realizar operacoes em base de dados para essa classe
@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }") //query personalizado (dados no link do material de apoio)
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text); //metodo de pesquisa ja encorporado no mongodb (verificar material de apoio)
	
}
