package com.lucaslearning.sbrestmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lucaslearning.sbrestmongodb.domain.User;

//a partir disso e possivel realizar operacoes em base de dados para essa classe
@Repository
public interface UserRepository extends MongoRepository<User, String>{
	
}
