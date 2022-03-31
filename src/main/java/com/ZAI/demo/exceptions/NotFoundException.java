package com.ZAI.demo.exceptions;

import java.io.UncheckedIOException;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
