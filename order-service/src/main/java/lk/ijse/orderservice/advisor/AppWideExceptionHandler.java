package lk.ijse.orderservice.advisor;

import lk.ijse.orderservice.exception.NotFoundException;
import lk.ijse.orderservice.exception.ValidationException;
import lk.ijse.orderservice.util.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author : Sanu Vithanage
 * @since : 0.1.0
 **/
@RestControllerAdvice
@CrossOrigin
public class AppWideExceptionHandler {

    @ExceptionHandler({Exception.class})
    public ResponseEntity handleException(Exception ex) {
        return new ResponseEntity(new Response("Error",ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity(new Response("Error",ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity handleValidationException(ValidationException ex) {
        return new ResponseEntity(new Response("Error",ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
