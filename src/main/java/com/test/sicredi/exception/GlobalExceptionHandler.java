package com.test.sicredi.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(field -> {
                    errors.put(field.getField(), field.getDefaultMessage());
                }
        );
      /*  AsResponse asResponse = new AsResponse();
        asResponse.setMsgRetrono("Parâmetros de entrada inválidos. Consulta a lista 'errors' neste json para mais informações.");
        asResponse.setErrors(errors);*/

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    private String createItem() {
        return "{'aa':'bb'}";
    }
}