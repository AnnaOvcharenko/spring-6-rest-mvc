package guru.springframework.spring6restmvc.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Anna Ovcharenko
 */
//@ControllerAdvice
@Slf4j
public class ExceptionController {

//    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException() {
        log.debug("In Not Found exception handler");
        return ResponseEntity.notFound().build();
    }
}
