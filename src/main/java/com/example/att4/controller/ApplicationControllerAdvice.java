package com.example.att4.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.att4.exceptions.ApiErros;
import com.example.att4.exceptions.RegraNegocios;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class  ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocios.class)
public ApiErros handlerRegraNegocioException(RegraNegocios ex) {
return new ApiErros(ex.getMessage());
}
    
}
