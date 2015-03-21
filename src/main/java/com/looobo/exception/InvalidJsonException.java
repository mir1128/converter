package com.looobo.exception;

import java.io.IOException;


public class InvalidJsonException extends RuntimeException {

    public InvalidJsonException(String message, Exception cause) {
        super(message, cause);
    }

    public InvalidJsonException(String message) {
        super(message);
    }

}
