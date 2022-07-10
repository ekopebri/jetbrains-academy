package cinema.exception;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException(String cause) {
        super(cause);
    }
}
