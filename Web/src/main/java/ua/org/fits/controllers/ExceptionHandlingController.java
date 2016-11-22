package ua.org.fits.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
@RestController
public class ExceptionHandlingController {

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String parse(Exception e) {
        return "Ошибка парсинга даты.";
    }
}
