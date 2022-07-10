package cinema.exception;

public class AlreadyPurchasedException extends RuntimeException{
    public AlreadyPurchasedException(String cause) {
        super(cause);
    }
}
