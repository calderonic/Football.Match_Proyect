package main.expections;

public class InvalidTeamOperationException extends Exception {
    public InvalidTeamOperationException(String message) {
        super(message);
    }
}
