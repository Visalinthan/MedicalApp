package com.app.medical.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class NotFound extends RuntimeException{

        public NotFound(String message) {
            super(message);
        }

}
