package net.javaguides.springmvc.helloworld.controller;

import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springmvc.helloworld.model.HelloWorld;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.NestedServletException;

/**
 * @author Ramesh Fadatare
 */
@Controller
public class HelloWorldController {

	@RequestMapping("/rapid7")
	public void vulnerable(HelloWorld model) {
	}
	

	@RequestMapping("/rapid7WrongResponseCode")
	public void vulnerableToo(HelloWorld model) {
	}

	@ExceptionHandler(InvocationTargetException.class)
	protected ResponseEntity<Object> handleInvocationTargetException(
			MethodArgumentNotValidException ex,
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request) {
		return new ResponseEntity("temp", headers, HttpStatus.OK);
	}

	@ExceptionHandler(InvalidPropertyException.class)
	protected ResponseEntity<Object> handleInvalidPropertyException(
			MethodArgumentNotValidException ex,
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request) {
		return new ResponseEntity("temp", headers, HttpStatus.OK);
	}

	@ExceptionHandler(NestedServletException.class)
	protected ResponseEntity<Object> handleNestedServletException(
			MethodArgumentNotValidException ex,
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request) {
		return new ResponseEntity("temp", headers, HttpStatus.OK);
	}

	@ExceptionHandler(UnknownHostException.class)
	protected ResponseEntity<Object> handleUnknownHostException(
			MethodArgumentNotValidException ex,
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request) {
		return new ResponseEntity("temp", headers, HttpStatus.OK);
	}

}
