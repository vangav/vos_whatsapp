/**
 * "First, solve the problem. Then, write the code. -John Johnson"
 * "Or use Vangav M"
 * www.vangav.com
 * */

/**
 * MIT License
 *
 * Copyright (c) 2016 Vangav
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to
 * deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or
 * sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 * */

/**
 * Community
 * Facebook Group: Vangav Open Source - Backend
 *   fb.com/groups/575834775932682/
 * Facebook Page: Vangav
 *   fb.com/vangav.f
 * 
 * Third party communities for Vangav Backend
 *   - play framework
 *   - cassandra
 *   - datastax
 *   
 * Tag your question online (e.g.: stack overflow, etc ...) with
 *   #vangav_backend
 *   to easier find questions/answers online
 * */

package com.vangav.vos_whatsapp.controllers;

import com.datastax.driver.core.ResultSet;
import com.vangav.backend.exceptions.BadRequestException;
import com.vangav.backend.exceptions.VangavException.ExceptionClass;
import com.vangav.backend.play_framework.ParentPlayHandler;
import com.vangav.backend.play_framework.request.Request;
import com.vangav.backend.play_framework.request.RequestJsonBody;
import com.vangav.vos_whatsapp.cassandra_keyspaces.wa_auth.AuthCreds;
import com.vangav.vos_whatsapp.controllers.common.Authenticator;

/**
 * GENERATED using ControllersGeneratorMain.java
 */
/**
 * CommonPlayHandler represents the parent handler for all controllers
 * */
public abstract class CommonPlayHandler extends ParentPlayHandler {

  @Override
  final protected void checkSource (
    final Request request) throws Exception {

     // Disabled functionality, set to true in request_properties.prop to enable
  }

  @Override
  final protected void throttle (
    final Request request) throws Exception {

     // Disabled functionality, set to true in request_properties.prop to enable
  }
  
  /**
   * getRequestAuthenticator
   * @param requestJsonBody
   * @return request's Authenticator Object to authenticate request or null
   *           if controller's request shouldn't be authenticated
   * @throws Exception
   */
  protected abstract Authenticator getRequestAuthenticator (
    final RequestJsonBody requestJsonBody) throws Exception;

  @Override
  protected void authenticateRequest (
    final Request request) throws Exception {

    // get request's authenticator Object
    Authenticator authenticator =
      this.getRequestAuthenticator(request.getRequestJsonBody() );
    
    // no authentication for this controller's request?
    if (authenticator == null) {
      
      return;
    }
    
    // select user's password
    ResultSet resultSet =
      AuthCreds.i().executeSyncSelect(authenticator.getUserId() );
    
    // user isn't signed up?
    if (resultSet.isExhausted() == true) {
      
      throw new BadRequestException(
        300,
        1,
        "No password for user's id ["
          + authenticator.getUserId().toString()
          + "]",
        ExceptionClass.AUTHENTICATION);
    }
    
    // get user's password
    String password = resultSet.one().getString(AuthCreds.kPasswordColumnName);
    
    // wrong password?
    if (password.compareTo(authenticator.getPassword() ) != 0) {
      
      throw new BadRequestException(
        300,
        2,
        "Wrong password for user's id ["
          + authenticator.getUserId().toString()
          + "], expected password ["
          + password
          + "] but got password ["
          + authenticator.getPassword()
          + "]",
        ExceptionClass.AUTHENTICATION);
    }
    
    // authentication went through successfully
  }

  @Override
  protected void afterProcessing (
    final Request request) throws Exception {

     // Override in a Controller's Handler to implement
  }

  @Override
  final protected void dispatchDefaultOperations (
    final Request request) throws Exception {

     // Disabled functionality, set to true in request_properties.prop to enable
  }

  @Override
  final protected void dispatchPushNotifications (
    final Request request) throws Exception {

     // Disabled functionality, set to true in request_properties.prop to enable
  }

  @Override
  protected void dispatchAnalysis (
    final Request request) throws Exception {

     // Override in a Controller's Handler to implement
  }

  @Override
  final protected void dispatchDefaultAnalysis (
    final Request request) throws Exception {

     // TODO: to be implemented
  }

  @Override
  protected void dispatchLogging (
    final Request request) throws Exception {

     // Override in a Controller's Handler to implement
  }

  @Override
  final protected void dispatchDefaultLogging (
    final Request request) throws Exception {

     // TODO: to be implemented
  }

  // IMPORTANT: this method must be implemented within a try and catch block
  //             because any exceptions thrown by this method will terminate
  //             the service instance and disables it from handling other
  //             requests
  @Override
  protected void absorbUnhandledExceptions (
    final Exception exception) {

    // TODO: implement here or override per-controller
  }

}
