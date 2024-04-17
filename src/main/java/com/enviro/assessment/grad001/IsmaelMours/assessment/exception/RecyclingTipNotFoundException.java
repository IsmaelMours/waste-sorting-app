package com.enviro.assessment.grad001.IsmaelMours.assessment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecyclingTipNotFoundException extends Throwable {
    public RecyclingTipNotFoundException(String message) {
        super(message);
    }
}
