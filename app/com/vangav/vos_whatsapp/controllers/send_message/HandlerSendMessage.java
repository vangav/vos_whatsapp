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

package com.vangav.vos_whatsapp.controllers.send_message;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ResultSet;
import com.vangav.backend.cassandra.Cassandra;
import com.vangav.backend.cassandra.formatting.CalendarFormatterInl;
import com.vangav.backend.exceptions.BadRequestException;
import com.vangav.backend.exceptions.VangavException.ExceptionClass;
import com.vangav.backend.play_framework.request.Request;
import com.vangav.backend.play_framework.request.RequestJsonBody;
import com.vangav.backend.play_framework.request.RequestState;
import com.vangav.backend.play_framework.request.response.ResponseBody;
import com.vangav.vos_whatsapp.cassandra_keyspaces.wa_analysis.MessagesCount;
import com.vangav.vos_whatsapp.cassandra_keyspaces.wa_auth.AuthCreds;
import com.vangav.vos_whatsapp.cassandra_keyspaces.wa_blobs.Messages;
import com.vangav.vos_whatsapp.cassandra_keyspaces.wa_chat.UserChats;
import com.vangav.vos_whatsapp.controllers.CommonPlayHandler;
import com.vangav.vos_whatsapp.controllers.common.Authenticator;

/**
 * GENERATED using ControllersGeneratorMain.java
 */
/**
 * HandlerSendMessage
 *   handles request-to-response processing
 *   also handles after response processing (if any)
 * */
public class HandlerSendMessage extends CommonPlayHandler {

  private static final String kName = "SendMessage";

  @Override
  protected String getName () {

    return kName;
  }

  @Override
  protected RequestJsonBody getRequestJson () {

    return new RequestSendMessage();
  }

  @Override
  protected ResponseBody getResponseBody () {

    return new ResponseSendMessage();
  }

  @Override
  protected Authenticator getRequestAuthenticator (
    final RequestJsonBody requestJsonBody) throws Exception {
    
    return
      new Authenticator(
        ((RequestSendMessage)requestJsonBody).user_id,
        ((RequestSendMessage)requestJsonBody).password);
  }

  @Override
  protected void processRequest (final Request request) throws Exception {

    // use the following request Object to process the request and set
    //   the response to be returned
    RequestSendMessage requestSendMessage =
      (RequestSendMessage)request.getRequestJsonBody();
    
    // sending message to self?
    if (requestSendMessage.getUserId().toString().compareTo(
          requestSendMessage.to_user_id) == 0) {
      
      throw new BadRequestException(
        303,
        1,
        "user_id ["
          + requestSendMessage.getUserId().toString()
          + "] is trying to send a message to her/him-self",
        ExceptionClass.INVALID);
    }
    
    // make to_user_id
    UUID toUserId = UUID.fromString(requestSendMessage.to_user_id);
    
    // check that to_user_id is registered
    ResultSet resultSet = AuthCreds.i().executeSyncSelect(toUserId);
    
    // to_user_id not registered?
    if (resultSet.isExhausted() == true) {
      
      throw new BadRequestException(
        303,
        2,
        "user_id ["
          + requestSendMessage.getUserId().toString()
          + "] is trying to send a message to an unregistered to_user_id ["
          + requestSendMessage.to_user_id
          + "]",
        ExceptionClass.INVALID);
    }
    
    // generate message's id
    UUID messageId = UUID.randomUUID();
    
    // make message's bytebuffer
    Charset charset = Charset.forName("UTF-8");
    CharsetEncoder encoder = charset.newEncoder();
    
    ByteBuffer messageByteBuffer =
      encoder.encode(CharBuffer.wrap(requestSendMessage.message) );
    
    // for storing bound statements
    ArrayList<BoundStatement> boundStatements =
      new ArrayList<BoundStatement>();
    
    // insert into messages
    boundStatements.add(
      Messages.i().getBoundStatementInsert(
        messageId,
        messageByteBuffer) );
    
    // insert into user_chats
    boundStatements.add(
      UserChats.i().getBoundStatementInsert(
        requestSendMessage.getUserId(),
        request.getStartTime(),
        requestSendMessage.getUserId(),
        toUserId,
        messageId) );
    
    // insert into user_chats reverse (for the receiving user)
    boundStatements.add(
      UserChats.i().getBoundStatementInsert(
        toUserId,
        request.getStartTime(),
        requestSendMessage.getUserId(),
        toUserId,
        messageId) );
    
    // execute bound statements
    Cassandra.i().executeSync(
      boundStatements.toArray(new BoundStatement[0] ) );
    
    // set response
    ((ResponseSendMessage)request.getResponseBody() ).set(
      request.getStartTime() );
  }

  @Override
  protected void dispatchAnalysis (
    final Request request) throws Exception {
    
    // request didn't go through?
    if (request.getState() != RequestState.OK) {
      
      return;
    }
    
    // dispatch analysis
    request.getDispatcher().addDispatchMessage(
      MessagesCount.i().getQueryDispatchableIncrement(
        CalendarFormatterInl.concatCalendarFields(
          request.getStartCalendar(),
          Calendar.YEAR,
          Calendar.MONTH,
          Calendar.DAY_OF_MONTH) ) );
  }
}
