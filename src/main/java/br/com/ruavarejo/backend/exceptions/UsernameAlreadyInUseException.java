package br.com.ruavarejo.backend.exceptions;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = BAD_REQUEST, reason = "This username is already in use")
public class UsernameAlreadyInUseException extends RuntimeException {
	private static final long serialVersionUID = 1L;
}
