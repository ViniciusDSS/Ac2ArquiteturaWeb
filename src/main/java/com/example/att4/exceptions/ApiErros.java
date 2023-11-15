package com.example.att4.exceptions;

import java.util.Arrays;
import java.util.*;
import lombok.Getter;


public class ApiErros {
    @Getter
    private List<String> errors;
    public ApiErros(String mensagemErro) {
    errors = Arrays.asList(mensagemErro);
    }
}
