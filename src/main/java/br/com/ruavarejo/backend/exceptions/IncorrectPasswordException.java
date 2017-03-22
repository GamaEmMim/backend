package br.com.ruavarejo.backend.exceptions;

import static org.springframework.http.HttpStatus.FORBIDDEN;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = FORBIDDEN, reason = "Incorrect password")
public class IncorrectPasswordException extends RuntimeException{
	private static final long serialVersionUID = 1L;
}