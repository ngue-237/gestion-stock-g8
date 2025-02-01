package com.logonedigital.gestion_stock_g8.exception;

public class ResourceExistException extends RuntimeException{
    public ResourceExistException(String message) {
        super(message);
    }
}
