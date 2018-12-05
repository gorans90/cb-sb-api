package com.carbook.http.server.exceptions.response;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Marko Pozdnjakov on 9/23/17.
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class Forbidden extends RuntimeException {
  public Forbidden(String message) {
    super(message);
  }
}
