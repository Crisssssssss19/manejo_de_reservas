package com.cris.manejo_de_reservas.exceptions;

public class ClienteNotFounException extends ResourceNotFounException{
    public ClienteNotFounException() {
    }

    public ClienteNotFounException(String message, Throwable cause) {
        super(message, cause);
    }

    public ClienteNotFounException(String message) {
        super(message);
    }
}
