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

package com.vangav.vos_whatsapp.controllers.common;

import java.util.UUID;

/**
 * @author mustapha
 * fb.com/mustapha.abdallah
 */
/**
 * Authenticator holds the params needed to authenticate a request
 * */
public class Authenticator {
  
  private final UUID userId;
  private final String password;
  
  /**
   * Constructor Authenticator
   * @param userId
   * @param password
   * @return new Authenticator Object
   * @throws Exception
   */
  public Authenticator (
    final String userId,
    final String password) throws Exception {
    
    this.userId = UUID.fromString(userId);
    this.password = password;
  }
  
  /**
   * getUserId
   * @return user's id
   * @throws Exception
   */
  public final UUID getUserId () throws Exception {
    
    return this.userId;
  }
  
  /**
   * getPassword
   * @return user's password
   * @throws Exception
   */
  public final String getPassword () throws Exception {
    
    return this.password;
  }
}
