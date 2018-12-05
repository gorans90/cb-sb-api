package com.carbook.http.server.service;

import com.carbook.http.server.common.ResponseMessage;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Base class for all Controllers, provides some utility methods.
 *
 * @author Marko Pozdnjakov on 3/7/17.
 */
public abstract class AbstractHttpService {

  /**
   * Creates {@link ResponseMessage} with message content "OK" and {@link HttpStatus} OK
   * @return ResponseMessage with message content "OK" and status OK
   */
  protected ResponseMessage<String> ok() {
    return ok("OK");
  }

  /**
   * Creates {@link ResponseMessage} with provided message content and {@link HttpStatus} OK
   * @param message message content
   * @return ResponseMessage with provided message content and status OK (200)
   */
  protected <T> ResponseMessage<T> ok(T message) {
    return response(message, HttpStatus.OK);
  }

  /**
   * Creates {@link ResponseMessage} with provided message content and {@link HttpStatus} OK
   * @param message message content
   * @return ResponseMessage with provided message content and status BAD_REQUEST (400)
   */
  protected <T> ResponseMessage<T> badRequest(T message){
    return response(message, HttpStatus.BAD_REQUEST);
  }

  /**
   * Creates {@link ResponseMessage} with provided message content and {@link HttpStatus} OK
   * @param message message content
   * @return ResponseMessage with provided message content and status INTERNAL_SERVER_ERROR (500)
   */
  protected <T> ResponseMessage<T> internalServerError(T message){
    return response(message, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  /**
   * Creates {@link ResponseMessage} with provided message content and {@link HttpStatus} OK
   * @param message message content
   * @return ResponseMessage with provided message content and status NOT_FOUND (404)
   */
  protected <T> ResponseMessage<T> notFound(T message){
    return response(message, HttpStatus.NOT_FOUND);
  }

  /**
   * Creates {@link ResponseMessage} with provided message content and status
   * @param message message content
   * @param status response status
   * @return ResponseMessage with provided message content and status
   */
  protected <T> ResponseMessage<T> response(T message, HttpStatus status) {
      ResponseMessage<T> response = new ResponseMessage<T>();
      response.setMessage(message);
      response.setStatus(status);
      return response;
  }

}
