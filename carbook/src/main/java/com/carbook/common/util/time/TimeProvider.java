package com.carbook.common.util.time;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Marko Pozdnjakov on 7/29/17.
 */
@Component
public class TimeProvider {
  private static final long serialVersionUID = -3301695478208950415L;

  public Date now() {
    return new Date();
  }
}
