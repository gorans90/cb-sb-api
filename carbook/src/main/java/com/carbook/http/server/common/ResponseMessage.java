package com.carbook.http.server.common;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import org.springframework.http.HttpStatus;

/**
 * Created by Marko Pozdnjakov on 3/7/17.
 */

@JsonPropertyOrder({"status", "message"})
public class ResponseMessage<T> {
  private HttpStatus status;
  private T message;

  public ResponseMessage() {
  }

  public ResponseMessage(T message, HttpStatus status) {
    this.message = message;
    this.status = status;
  }

  public HttpStatus getStatus() {
    return this.status;
  }

  public void setStatus(HttpStatus status) {
    this.status = status;
  }

  public T getMessage() {
    return this.message;
  }

  public void setMessage(T message) {
    this.message = message;
  }
}
