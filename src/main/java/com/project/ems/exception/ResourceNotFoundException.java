package com.project.ems.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

    private final transient Object[] args;

    public ResourceNotFoundException(String message, Object[] args) {
        super(message);
        this.args = args;
    }

    public ResourceNotFoundException(String message) {
        super(message);
        this.args = new Object[0];
    }
}
