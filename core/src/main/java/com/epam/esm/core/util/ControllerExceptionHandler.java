package com.epam.esm.core.util;

import com.epam.esm.entity.dto.ErrorData;
import com.epam.esm.service.exception.ParameterNotPresentException;
import com.epam.esm.service.util.ExceptionMessageConstants;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Log4j2
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ParameterNotPresentException.class)
    protected ResponseEntity<Object> handleParameterNotPresentException(ParameterNotPresentException exception,
                                                                        WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String messageName = ExceptionMessageConstants.getMessageForLocale(exception.getMessageName(),
                request.getLocale());
        log.error(messageName, exception);
        ErrorData errorData = new ErrorData(messageName,
                status.value() + exception.getEntityCode());
        return handleExceptionInternal(exception, errorData,
                new HttpHeaders(), status, request);
    }

}
