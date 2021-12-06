
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

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * All controllers can access this class
 * 
 * @author Ghiles
 * @version 1.0
 */

@ControllerAdvice
public class ApiExceptionsHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDetails> handlerApiExceptions(NotFoundException ex, WebRequest request) {
		ErrorDetails details = new ErrorDetails(ex.getMessage(), request.getDescription(false));

		return new ResponseEntity<>(details, ex.getStatusCode());
	}
}
