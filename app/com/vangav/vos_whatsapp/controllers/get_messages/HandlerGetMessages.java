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

package com.vangav.vos_whatsapp.controllers.get_messages;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.ArrayList;
import java.util.UUID;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.vangav.backend.exceptions.CodeException;
import com.vangav.backend.exceptions.VangavException;
import com.vangav.backend.exceptions.VangavException.ExceptionClass;
import com.vangav.backend.play_framework.request.Request;
import com.vangav.backend.play_framework.request.RequestJsonBody;
import com.vangav.backend.play_framework.request.response.ResponseBody;
import com.vangav.vos_whatsapp.cassandra_keyspaces.wa_blobs.Messages;
import com.vangav.vos_whatsapp.cassandra_keyspaces.wa_chat.UserChats;
import com.vangav.vos_whatsapp.controllers.CommonPlayHandler;
import com.vangav.vos_whatsapp.controllers.common.Authenticator;
import com.vangav.vos_whatsapp.controllers.get_messages.response_json.ResponseMessage;

/**
 * GENERATED using ControllersGeneratorMain.java
 */
/**
 * HandlerGetMessages
 *   handles request-to-response processing
 *   also handles after response processing (if any)
 * */
public class HandlerGetMessages extends CommonPlayHandler {

  private static final String kName = "GetMessages";

  @Override
  protected String getName () {

    return kName;
  }

  @Override
  protected RequestJsonBody getRequestJson () {

    return new RequestGetMessages();
  }

  @Override
  protected ResponseBody getResponseBody () {

    return new ResponseGetMessages();
  }

  @Override
  protected Authenticator getRequestAuthenticator (
    final RequestJsonBody requestJsonBody) throws Exception {
    
    return
      new Authenticator(
        ((RequestGetMessages)requestJsonBody).user_id,
        ((RequestGetMessages)requestJsonBody).password);
  }

  @Override
  protected void processRequest (final Request request) throws Exception {

    // use the following request Object to process the request and set
    //   the response to be returned
    RequestGetMessages requestGetMessages =
      (RequestGetMessages)request.getRequestJsonBody();
    
    ResultSet resultSet;
    
    // get recent messages or recent messages?
    if (requestGetMessages.isValidParam(
          RequestGetMessages.kFromTimeName) == true) {
      
      resultSet =
        UserChats.i().executeSyncSelectRecent(
          requestGetMessages.getUserId(),
          requestGetMessages.from_time);
    } else {
      
      resultSet =
        UserChats.i().executeSyncSelectAll(
          requestGetMessages.getUserId() );
    }
    
    // init messages array list
    ArrayList<ResponseMessage> messages = new ArrayList<ResponseMessage>();
    
    // row holder
    ResultSet currResultSet;
    Row currRow;
    String currFromUserId;
    String currToUserId;
    long currMessageTime;
    UUID currMessageId;
    String currMessage;
    
    // extract rows
    while (resultSet.isExhausted() == false) {
      
      currRow = resultSet.one();
      
      currFromUserId =
        currRow.getUUID(UserChats.kSenderUserIdColumnName).toString();
      currToUserId =
        currRow.getUUID(UserChats.kReceiverUserIdColumnName).toString();
      currMessageTime =
        currRow.getLong(UserChats.kMessageTimeColumnName);
      currMessageId =
        currRow.getUUID(UserChats.kMessageIdColumnName);
      
      // get message
      try {
        
        currResultSet = Messages.i().executeSyncSelect(currMessageId);
        
        // didn't find message?
        if (currResultSet.isExhausted() == true) {
          
          throw new CodeException(
            304,
            1,
            "Missing message for user_id ["
              + requestGetMessages.getUserId().toString()
              + "], message_time ["
              + currMessageTime
              + "], sender_user_id ["
              + currFromUserId
              + "], message_id ["
              + currMessageId.toString()
              + "]",
            ExceptionClass.MISSING_ITEM);
        }
        
        // get message
        
        ByteBuffer messageByteBuffer =
          currResultSet.one().getBytes(Messages.kMessageColumnName);
        
        Charset charset = Charset.forName("UTF-8");
        CharsetDecoder decoder = charset.newDecoder();
        
        int oldPosition = messageByteBuffer.position();

        currMessage = decoder.decode(messageByteBuffer).toString();
        
        messageByteBuffer.position(oldPosition);
        
        // add message
        messages.add(
          new ResponseMessage(
            currFromUserId,
            currToUserId,
            currMessageTime,
            currMessage) );
      } catch (VangavException ve) {
        
        request.addVangavException(ve);
      } catch (Exception e) {
        
        request.addException(e);
      }
    }
    
    // set response
    ((ResponseGetMessages)request.getResponseBody() ).set(
      messages.toArray(new ResponseMessage[0] ) );
  }
}
