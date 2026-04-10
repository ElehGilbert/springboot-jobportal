package com.dreamsiteco.jobportal.exception;

import com.dreamsiteco.jobportal.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.method.ParameterValidationResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class) //Exception.class so we can handle all the different types of exception with
    public  ResponseEntity<ErrorResponseDto> handleException(Exception exception,
                                                             WebRequest webRequest )
    {
        ErrorResponseDto errorResponseDto =new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now());


        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<Map<String, String>> handleException(HandlerMethodValidationException exception)
    {
        Map<String, String> errors = new HashMap<>();
        List<ParameterValidationResult> results= exception.getParameterValidationResults();
        results.forEach(result->{
            String paramName = result.getMethodParameter().getParameterName();


            //Combine all messages into a single comma-separated string
            String conbinedMessage = result.getResolvableErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage()) //extract each message
                    .collect(Collectors.joining(","));
            errors.put(paramName, conbinedMessage);


        });

        return ResponseEntity.badRequest().body(errors);
    }





    //Doing this so I pass the exact validation message of the DTO with its exact message
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public  ResponseEntity<Map<String,String>> handleException(MethodArgumentNotValidException exception)
    {
        Map<String,String> errors =new HashMap<>();
        List<FieldError> fieldErrorList = exception.getBindingResult().getFieldErrors(); //Knowing the field error details
        fieldErrorList.forEach((error -> errors.put(error.getField(),error.getDefaultMessage())));

        return ResponseEntity.badRequest().body(errors);


    }







    @ExceptionHandler(NullPointerException.class)
    public  ResponseEntity<ErrorResponseDto> handleNullException(Exception exception,
                                                             WebRequest webRequest )
    {
        ErrorResponseDto errorResponseDto =new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR,
                "A NullPointerException occured due to: "+ exception.getMessage(),
                LocalDateTime.now());

        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
