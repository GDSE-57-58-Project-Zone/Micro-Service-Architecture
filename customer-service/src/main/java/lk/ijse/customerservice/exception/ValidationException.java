package lk.ijse.customerservice.exception;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}
