package net.javaguides.springmvc.helloworld.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.handler.ExceptionHandlingWebHandler;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.NestedServletException;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
    protected final Log logger = LogFactory.getLog(this.getClass());

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        logger.error("Context path: " + request.getContextPath());
        logger.error("Status: " + status);
        logger.error("Status value: " + status.value());
        logger.error("Is client error: " + status.is4xxClientError());
        logger.error("Status: " + status.toString());
        logger.error("Status series: " + status.series().toString());
        logger.error("Status series value: " + status.series().value());
        logger.error("Status series second: " + status.series().name());

        System.out.println("Context path: " + request.getContextPath());
        System.out.println("Status: " + status);
        System.out.println("Status value: " + status.value());
        System.out.println("Is client error: " + status.is4xxClientError());
        System.out.println("Status: " + status.toString());
        System.out.println("Status series: " + status.series().toString());
        System.out.println("Status series value: " + status.series().value());
        System.out.println("Status series second: " + status.series().name());

        return this.handleExceptionInternal(ex, "testing stuff", headers, HttpStatus.OK, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity(body, headers, HttpStatus.OK);
    }

    @ExceptionHandler(InvocationTargetException.class)
    protected ResponseEntity<Object> handleInvocationTargetException(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        return this.handleExceptionInternal(ex, "testing stuff", headers, HttpStatus.OK, request);
    }

    @ExceptionHandler(InvalidPropertyException.class)
    protected ResponseEntity<Object> handleInvalidPropertyException(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        return this.handleExceptionInternal(ex, "testing stuff", headers, HttpStatus.OK, request);
    }

    @ExceptionHandler(NestedServletException.class)
    protected ResponseEntity<Object> handleNestedServletException(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        return this.handleExceptionInternal(ex, "testing stuff", headers, HttpStatus.OK, request);
    }

    @ExceptionHandler(UnknownHostException.class)
    protected ResponseEntity<Object> handleUnknownHostException(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {
        return this.handleExceptionInternal(ex, "testing stuff", headers, HttpStatus.OK, request);
    }
}
