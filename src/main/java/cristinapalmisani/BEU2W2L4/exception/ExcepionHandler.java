package cristinapalmisani.BEU2W2L4.exception;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExcepionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorPayload handelNotFound(NotFoundException ex){
        return new ErrorPayload(ex.getMessage(), LocalDateTime.now());
    }
    @ExceptionHandler(BadRequestException.class)
    // Indico che questo metodo gestirà le eccezioni di tipo BadRequestException
    @ResponseStatus(HttpStatus.BAD_REQUEST) // Dovrà rispondere con un 400
    public ErrorPayload handleBadRequest(BadRequestException ex) {
        return new ErrorPayload(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorPayload handleServerError(Exception ex){
        ex.printStackTrace();
        return new ErrorPayload(ex.getMessage(), LocalDateTime.now());
    }
}
