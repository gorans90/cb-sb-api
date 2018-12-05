package com.carbook.services.user.operations;

import com.carbook.services.user.operations.creator.UserCreator;
import com.carbook.services.user.operations.lister.UserLister;
import com.carbook.services.user.operations.updater.UserUpdater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Marko Pozdnjakov on 8/6/17.
 */
@Component
public class UserOperationFactory  {
  @Autowired
  protected UserLister lister;
  @Autowired
  protected UserCreator creator;
  @Autowired
  protected UserUpdater updater;

  public UserOperationFactory(){}

  /**
   * User lister
   */
  public UserLister getLister(){ return  lister;}

  /**
   * User updater
   */
  public UserUpdater getUpdater(){ return  updater;}

  /**
   * User creator
   */
  public UserCreator getCreator(){ return  creator;}
}
