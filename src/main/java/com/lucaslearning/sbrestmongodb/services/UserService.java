package com.lucaslearning.sbrestmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaslearning.sbrestmongodb.domain.User;
import com.lucaslearning.sbrestmongodb.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired //injecao de dependencia automatica do spring
	private UserRepository rep;
	
	public List<User> findAll(){
		return rep.findAll();
	}
}
