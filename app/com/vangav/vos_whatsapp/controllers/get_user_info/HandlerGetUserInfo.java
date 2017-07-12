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

package com.vangav.vos_whatsapp.controllers.get_user_info;

import java.util.UUID;

import com.datastax.driver.core.ResultSet;
import com.vangav.backend.exceptions.BadRequestException;
import com.vangav.backend.exceptions.CodeException;
import com.vangav.backend.exceptions.VangavException.ExceptionClass;
import com.vangav.backend.play_framework.request.Request;
import com.vangav.backend.play_framework.request.RequestJsonBody;
import com.vangav.backend.play_framework.request.response.ResponseBody;
import com.vangav.vos_whatsapp.cassandra_keyspaces.wa_auth.PhoneNumbers;
import com.vangav.vos_whatsapp.cassandra_keyspaces.wa_users.UsersInfo;
import com.vangav.vos_whatsapp.controllers.CommonPlayHandler;
import com.vangav.vos_whatsapp.controllers.common.Authenticator;

/**
 * GENERATED using ControllersGeneratorMain.java
 */
/**
 * HandlerGetUserInfo
 *   handles request-to-response processing
 *   also handles after response processing (if any)
 * */
public class HandlerGetUserInfo extends CommonPlayHandler {

  private static final String kName = "GetUserInfo";

  @Override
  protected String getName () {

    return kName;
  }

  @Override
  protected RequestJsonBody getRequestJson () {

    return new RequestGetUserInfo();
  }

  @Override
  protected ResponseBody getResponseBody () {

    return new ResponseGetUserInfo();
  }

  @Override
  protected Authenticator getRequestAuthenticator (
    final RequestJsonBody requestJsonBody) throws Exception {
    
    return
      new Authenticator(
        ((RequestGetUserInfo)requestJsonBody).user_id,
        ((RequestGetUserInfo)requestJsonBody).password);
  }

  @Override
  protected void processRequest (final Request request) throws Exception {

    // use the following request Object to process the request and set
    //   the response to be returned
    RequestGetUserInfo requestGetUserInfo =
      (RequestGetUserInfo)request.getRequestJsonBody();
    
    // get user's id
    ResultSet resultSet =
      PhoneNumbers.i().executeSyncSelect(
        requestGetUserInfo.get_user_info_phone_number);
    
    // user not registered?
    if (resultSet.isExhausted() == true) {
      
      throw new BadRequestException(
        302,
        1,
        "User with phone number ["
          + requestGetUserInfo.get_user_info_phone_number
          + "] is not registered",
        ExceptionClass.INVALID);
    }
    
    // get user's id
    UUID userId = resultSet.one().getUUID(PhoneNumbers.kUserIdColumnName);
    
    // get user's name
    resultSet =
      UsersInfo.i().executeSyncSelectName(userId);
    
    // not user info?
    if (resultSet.isExhausted() == true) {
      
      throw new CodeException(
        302,
        2,
        "Didn't find user_info for user_id ["
          + userId.toString()
          + "] and phone_number ["
          + requestGetUserInfo.get_user_info_phone_number
          + "]",
        ExceptionClass.MISSING_ITEM);
    }
    
    // get user's name
    String name = resultSet.one().getString(UsersInfo.kNameColumnName);
    
    // set response
    ((ResponseGetUserInfo)request.getResponseBody() ).set(
      userId.toString(),
      name);
  }
}
