package fr.application.codingame.error;

import org.springframework.http.HttpStatus;

/**
 * 
 * @author Ghiles HIDEUR
 * @version 1.0
 */

public class NotFoundException extends ApiBaseException {


	private static final long serialVersionUID = 1L;

	public NotFoundException(String message) {
		super(message);
	}

	@Override
	public HttpStatus getStatusCode() {
		return HttpStatus.NOT_FOUND;
	}
}
