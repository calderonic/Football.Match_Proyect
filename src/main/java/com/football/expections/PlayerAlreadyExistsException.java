package com.football.expections;

public class PlayerAlreadyExistsException extends Exception {
    public PlayerAlreadyExistsException(String message) {
        super(message);
    }
}
