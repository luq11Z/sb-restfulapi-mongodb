package com.lucaslearning.sbrestmongodb.services.exception;

//runtime nao exige que seja tratada
public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException (String msg) {
		super(msg);
	}
}
