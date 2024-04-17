package org.example.firsteverproductservice.exceptionhandler;

import org.example.firsteverproductservice.Dtos.ExceptionDto;
import org.example.firsteverproductservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@ControllerAdvice
public class GlobalExceptionhandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmaticException(){
    ExceptionDto exceptionDto = new ExceptionDto();
    exceptionDto.setMessage("Arithmatic Exception is found");
    exceptionDto.setResolution("donot divide by zero");
    ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    return response;
    }
    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> handleArrayIndexOutofBound(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("ArrayIndexOutofBound Exception is found");
        exceptionDto.setResolution("use vaid index");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return response;
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleGeneralException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(" Exception is found");
        exceptionDto.setResolution("do something");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return response;
    }
@ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Product id "+ productNotFoundException.getId()+" is INVALID");
        exceptionDto.setResolution("provide valid product id");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
        return response;
    }


}
