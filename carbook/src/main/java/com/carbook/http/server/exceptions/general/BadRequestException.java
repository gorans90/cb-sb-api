package com.carbook.http.server.exceptions.general;

/**
 * Created by Marko Pozdnjakov on 9/23/17.
 */
public class BadRequestException extends Exception {
  public BadRequestException(String message) {
    super(message);
  }
}
