package com.example.proiect_adv;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class MaterieControllerAdvice {

    @ResponseBody
    @ExceptionHandler(MaterieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String materieNotFoundHandler(MaterieNotFoundException ex) {
        return ex.getMessage();
    }
}