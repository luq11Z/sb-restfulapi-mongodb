package com.lucaslearning.sbrestmongodb.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lucaslearning.sbrestmongodb.services.exception.ObjectNotFoundException;

@ControllerAdvice //indica que a classe e responsavel por tratar possiveis erros nas requisicoes
public class ResourceExceptionHandler {
	
	//metodo para tratar ObjectNotFoundException
	//parametros tipo de excecao a tratar e a exigencia do framework
	@ExceptionHandler(ObjectNotFoundException.class) //padrao da framework serve para identificar que quando ocorrer essa excecao esse e o tratamento a ser feito
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err); //controlar manualmente o status a retornar e a respectiva mensagem
	}
}
