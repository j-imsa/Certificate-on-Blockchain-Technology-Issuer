package com.innovationchain.certificateonblockchaintechnologyissuer.ws.exception;

import com.innovationchain.certificateonblockchaintechnologyissuer.ws.ui.model.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler {

    // handle a specific exception
    @ExceptionHandler(value = {ConnectionServiceException.class})
    public ResponseEntity<Object> handleUserServiceException(ConnectionServiceException connectionServiceException, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), connectionServiceException.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // handle a specific exception
    @ExceptionHandler(value = {WalletServiceException.class})
    public ResponseEntity<Object> WalletServiceException(WalletServiceException walletServiceException, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), walletServiceException.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // handle all exceptions
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleUserServiceException(Exception exception, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(new Date(), exception.getMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
