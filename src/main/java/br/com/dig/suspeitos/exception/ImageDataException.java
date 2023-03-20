package br.com.dig.suspeitos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class ImageDataException extends Exception {

    public ImageDataException(String name) {
        super("Could not upload the file" + name);
    }
}
