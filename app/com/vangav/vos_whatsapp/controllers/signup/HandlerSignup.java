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

package com.vangav.vos_whatsapp.controllers.signup;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ResultSet;
import com.vangav.backend.cassandra.Cassandra;
import com.vangav.backend.cassandra.formatting.CalendarFormatterInl;
import com.vangav.backend.exceptions.BadRequestException;
import com.vangav.backend.exceptions.CodeException;
import com.vangav.backend.exceptions.VangavException.ExceptionClass;
import com.vangav.backend.play_framework.request.Request;
import com.vangav.backend.play_framework.request.RequestJsonBody;
import com.vangav.backend.play_framework.request.RequestState;
import com.vangav.backend.play_framework.request.response.ResponseBody;
import com.vangav.vos_whatsapp.cassandra_keyspaces.wa_analysis.UsersCount;
import com.vangav.vos_whatsapp.cassandra_keyspaces.wa_auth.AuthCreds;
import com.vangav.vos_whatsapp.cassandra_keyspaces.wa_auth.PhoneNumbers;
import com.vangav.vos_whatsapp.cassandra_keyspaces.wa_users.UsersInfo;
import com.vangav.vos_whatsapp.controllers.CommonPlayHandler;
import com.vangav.vos_whatsapp.controllers.common.Authenticator;

/**
 * GENERATED using ControllersGeneratorMain.java
 */
/**
 * HandlerSignup
 *   handles request-to-response processing
 *   also handles after response processing (if any)
 * */
public class HandlerSignup extends CommonPlayHandler {

  private static final String kName = "Signup";

  @Override
  protected String getName () {

    return kName;
  }

  @Override
  protected RequestJsonBody getRequestJson () {

    return new RequestSignup();
  }

  @Override
  protected ResponseBody getResponseBody () {

    return new ResponseSignup();
  }

  @Override
  protected Authenticator getRequestAuthenticator (
    final RequestJsonBody requestJsonBody) throws Exception {
    
    return null;
  }
  
  private boolean isSignup = false;

  @Override
  protected void processRequest (final Request request) throws Exception {

    // use the following request Object to process the request and set
    //   the response to be returned
    RequestSignup requestSignup =
      (RequestSignup)request.getRequestJsonBody();
    
    // check if this user is signed up already
    ResultSet resultSet =
      PhoneNumbers.i().executeSyncSelect(requestSignup.phone_number);
    
    // already signed up?
    if (resultSet.isExhausted() == false) {
      
      // get user's id
      UUID userId = resultSet.one().getUUID(PhoneNumbers.kUserIdColumnName);
      
      // set request's user id
      request.setUserId(userId);
      
      // get user's password from auth_creds
      resultSet = AuthCreds.i().executeSyncSelect(userId);
      
      // no password?
      if (resultSet.isExhausted() == true) {
        
        throw new CodeException(
          301,
          1,
          "No password for user with phone number ["
            + requestSignup.phone_number
            + "] and user_id ["
            + userId.toString()
            + "]",
          ExceptionClass.AUTHENTICATION);
      }
      
      // get user's password
      String userPassword =
        resultSet.one().getString(AuthCreds.kPasswordColumnName);
      
      // wrong password?
      if (userPassword.compareTo(requestSignup.password) != 0) {
        
        throw new BadRequestException(
          301,
          2,
          "Wrong password for user_id ["
            + userId.toString()
            + "], expected password ["
            + userPassword
            + "] but got password ["
            + requestSignup.password
            + "]",
          ExceptionClass.AUTHENTICATION);
      }
      
      // all clear, set response
      ((ResponseSignup)request.getResponseBody() ).set(userId.toString() );
      
      return;
    }
    
    // new user processing
    
    // set isSignup
    this.isSignup = true;
    
    // generate new user's id
    UUID userId = UUID.randomUUID();
    
    // set request's user id
    request.setUserId(userId);
    
    // for storing bound statements
    ArrayList<BoundStatement> boundStatements =
      new ArrayList<BoundStatement>();

    // insert into phone_numbers
    boundStatements.add(
      PhoneNumbers.i().getBoundStatementInsert(
        requestSignup.phone_number,
        userId) );
    
    // insert into auth_creds
    boundStatements.add(
      AuthCreds.i().getBoundStatementInsert(
        userId,
        requestSignup.password) );
    
    // insert into users_info
    boundStatements.add(
      UsersInfo.i().getBoundStatementInsert(
        userId,
        requestSignup.name,
        requestSignup.phone_number,
        requestSignup.phone_type,
        requestSignup.device_token) );
    
    // execute bound statements
    Cassandra.i().executeSync(
      boundStatements.toArray(new BoundStatement[0] ) );

    // set response
    ((ResponseSignup)request.getResponseBody() ).set(userId.toString() );
  }

  @Override
  protected void dispatchAnalysis (
    final Request request) throws Exception {
    
    // request didn't go through?
    if (request.getState() != RequestState.OK) {
      
      return;
    }
    
    // not a new user?
    if (this.isSignup == false) {
      
      return;
    }
    
    // dispatch analysis
    request.getDispatcher().addDispatchMessage(
      UsersCount.i().getQueryDispatchableIncrement(
        CalendarFormatterInl.concatCalendarFields(
          request.getStartCalendar(),
          Calendar.YEAR,
          Calendar.MONTH,
          Calendar.DAY_OF_MONTH) ) );
  }
}
