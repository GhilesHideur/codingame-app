package fr.application.codingame.error;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * This class allows to custom the validation error 
 * Each represents an input field error
 * 
 * @author Ghiles HIDEUR
 * @version 1.0
 */

@Data
public class ValidationError {


	private List<String> errors;

	private String uri;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date temstamp;

	public ValidationError() {
		this.temstamp = new Date();
		this.errors = new ArrayList<String>();
	}

	/**
	 * Add an error to the list
	 * 
	 * @param error
	 */
	
	public void addError(String error) {
		this.errors.add(error);
	}
}
