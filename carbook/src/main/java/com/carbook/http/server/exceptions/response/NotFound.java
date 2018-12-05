package com.carbook.http.server.exceptions.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Marko Pozdnjakov on 12/13/17.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFound extends RuntimeException {
  public NotFound(String message) {
    super(message);
  }
}