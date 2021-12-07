package fr.application.codingame.error;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * this class allows to customize the error message
 * 
 * @author Ghiles HIDEUR
 * @version 1.0
 */

@Data
public class ErrorDetails {

	private String message;
	private String uri;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date timestamp;

	public ErrorDetails() {
		this.timestamp = new Date();
	}

	public ErrorDetails(String message, String uri) {
		this();
		this.message = message;
		this.uri = uri;
	}
}
