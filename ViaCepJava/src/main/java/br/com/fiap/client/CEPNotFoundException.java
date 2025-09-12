package br.com.fiap.client;

public class CEPNotFoundException extends RuntimeException {
    public CEPNotFoundException(String message) {
        super(message);
    }

    public CEPNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
