package com.cris.manejo_de_reservas.exceptions;

public class ResourceNotFounException extends RuntimeException{
    public ResourceNotFounException() {
    }

    public ResourceNotFounException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResourceNotFounException(String message) {
        super(message);
    }
}
