package com.epam.esm.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ParameterNotPresentException extends Exception {

    public final String entityCode;

    public final String messageName;

    public ParameterNotPresentException(String entityCode, String messageName) {
        super();
        this.entityCode = entityCode;
        this.messageName = messageName;
    }

    public ParameterNotPresentException(Throwable cause, String entityCode, String messageName) {
        super(cause);
        this.entityCode = entityCode;
        this.messageName = messageName;
    }

    public String getMessageName() {
        return messageName;
    }

    public String getEntityCode() {
        return entityCode;
    }

}
