package fr.application.codingame.error;

import org.springframework.http.HttpStatus;

/**
 * @author Ghiles HIDEUR
 * @version 1.0
 */

public abstract class ApiBaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ApiBaseException(String message) {
		super(message);
	}

	abstract public HttpStatus getStatusCode();
}
