package com.carbook.common.util.logging;

import org.slf4j.Logger;
import org.slf4j.helpers.MessageFormatter;

/**
 * Request timer - measurement request duration
 * Marko Pozdnjakov on 3/14/17.
 */
public class RequestTimer {

  private final Logger logger;
  private final long start;
  private String message;

  public RequestTimer(Logger logger, String messageFormat, Object... args) {
    start = System.currentTimeMillis();
    this.logger = logger;
    this.message = MessageFormatter.arrayFormat(messageFormat, args).getMessage();
  }

  public void done() {
    long time = System.currentTimeMillis() - start;
    logger.info("{}: {}ms", message, time);
  }
}
