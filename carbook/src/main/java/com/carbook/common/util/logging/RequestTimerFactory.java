package com.carbook.common.util.logging;

import org.slf4j.Logger;

/**
 * Created by Marko Pozdnjakov on 3/14/17.
 */
public class RequestTimerFactory {
  private final Logger logger;

  public RequestTimerFactory(Logger logger) {
    this.logger = logger;
  }

  public RequestTimer getTimer(String messageFormat, Object... args) {
    return new RequestTimer(logger, messageFormat, args);
  }
}
