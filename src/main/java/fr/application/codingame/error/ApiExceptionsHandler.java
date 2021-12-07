package fr.application.codingame.error;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * All controllers can access this class
 * 
 * @author Ghiles HIDEUR
 * @version 1.0
 */

@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ApiBaseException.class)
	public ResponseEntity<ErrorDetails> handlerApiExceptions(ApiBaseException ex, WebRequest request) {
		ErrorDetails details = new ErrorDetails(ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(details, ex.getStatusCode());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ValidationError validationError = new ValidationError();
		validationError.setUri(request.getDescription(false));

		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

		for (FieldError fieldError : fieldErrors) {
			validationError.addError(fieldError.getDefaultMessage());
		}

		return new ResponseEntity<>(validationError,HttpStatus.BAD_REQUEST);
	}
}
