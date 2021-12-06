package fr.application.codingame.error;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException {


	private static final long serialVersionUID = 1L;

	public NotFoundException(String message) {
		super(message);
	}

	public HttpStatus getStatusCode() {
		return HttpStatus.NOT_FOUND;
	}
}
