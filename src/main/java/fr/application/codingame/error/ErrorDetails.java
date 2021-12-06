
/*
 * Copyright 2021 Ghiles HIDEUR.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.application.codingame.error;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
/**
 * this class allows to customize the error message
 * 
 * @author ghiles
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
