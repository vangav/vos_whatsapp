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

package com.vangav.vos_whatsapp.cassandra_keyspaces.wa_auth;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.ResultSetFuture;
import com.vangav.backend.cassandra.keyspaces.Query;
import com.vangav.backend.cassandra.keyspaces.Table;
import com.vangav.backend.cassandra.keyspaces.dispatch_message.QueryDispatchable;

/**
 * GENERATED using JavaClientGeneratorMain.java
 */
/**
 * PhoneNumbers represents
 *   Table [phone_numbers]
 *   in Keyspace [wa_auth]
 * 
 * Name: phone_numbers
 * Description:
 *   used to map phone numbers to users' ids 
 * 
 * Columns:
 *   phone_number : varchar
 *   user_id : uuid

 * Partition Keys: phone_number
 * Secondary Keys: 
 * Caching: ALL
 * Order By:

 * Queries:
 *   - Name: insert
 *   Description:
 *     inserts new user's phone number and user id 
 *   Prepared Statement:
 *     INSERT INTO wa_auth.phone_numbers (phone_number, user_id) VALUES 
 *     (:phone_number, :user_id); 
 *   - Name: select
 *   Description:
 *     selects a phone number's user id 
 *   Prepared Statement:
 *     SELECT user_id FROM wa_auth.phone_numbers WHERE phone_number = 
 *     :phone_number; 
 * */
public class PhoneNumbers extends Table {

  private static final String kKeySpaceName =
    "wa_auth";
  private static final String kTableName =
    "phone_numbers";

  public static final String kPhoneNumberColumnName =
    "phone_number";
  public static final String kUserIdColumnName =
    "user_id";

  /**
   * Query:
   * Name: insert
   * Description:
   *   inserts new user's phone number and user id 
   * Prepared Statement:
   *   INSERT INTO wa_auth.phone_numbers (phone_number, user_id) VALUES 
   *   (:phone_number, :user_id); 
   */
  private static final String kInsertName =
    "insert";
  private static final String kInsertDescription =
    "inserts new user's phone number and user id ";
  private static final String kInsertPreparedStatement =
    "INSERT INTO wa_auth.phone_numbers (phone_number, user_id) VALUES "
    + "(:phone_number, :user_id); ";

  /**
   * Query:
   * Name: select
   * Description:
   *   selects a phone number's user id 
   * Prepared Statement:
   *   SELECT user_id FROM wa_auth.phone_numbers WHERE phone_number = 
   *   :phone_number; 
   */
  private static final String kSelectName =
    "select";
  private static final String kSelectDescription =
    "selects a phone number's user id ";
  private static final String kSelectPreparedStatement =
    "SELECT user_id FROM wa_auth.phone_numbers WHERE phone_number = "
    + ":phone_number; ";

  /**
   * Constructor PhoneNumbers
   * @return new PhoneNumbers Object
   * @throws Exception
   */
  private PhoneNumbers () throws Exception {

    super (
      kKeySpaceName,
      kTableName,
      new Query (
        kInsertDescription,
        kInsertName,
        kInsertPreparedStatement),
      new Query (
        kSelectDescription,
        kSelectName,
        kSelectPreparedStatement));
  }

  private static PhoneNumbers instance = null;

  /**
   * loadTable
   * OPTIONAL method
   * instance is created either upon calling this method or upon the first call
   *   to singleton instance method i
   * this method is useful for loading upon program start instead of loading
   *   it upon the first use since there's a small time overhead for loading
   *   since all queries are prepared synchronously in a blocking network
   *   operation with Cassandra's server
   * @throws Exception
   */
  public static void loadTable () throws Exception {

    if (instance == null) {

      instance = new PhoneNumbers();
    }
  }

  /**
   * i
   * @return singleton static instance of PhoneNumbers
   * @throws Exception
   */
  public static PhoneNumbers i () throws Exception {

    if (instance == null) {

      instance = new PhoneNumbers();
    }

    return instance;
  }

  // Query: Insert
  // Description:
  //   inserts new user's phone number and user id 
  // Parepared Statement:
  //   INSERT INTO wa_auth.phone_numbers (phone_number, user_id) VALUES 
  //   (:phone_number, :user_id); 

  /**
   * getQueryInsert
   * @return Insert Query in the form of
   *           a Query Object
   * @throws Exception
   */
  public Query getQueryInsert (
    ) throws Exception {

    return this.getQuery(kInsertName);
  }

  /**
   * getQueryDispatchableInsert
   * @param phonenumber
   * @param userid
   * @return Insert Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableInsert (
    Object phonenumber,
    Object userid) throws Exception {

    return
      this.getQueryDispatchable(
        kInsertName,
        phonenumber,
        userid);
  }

  /**
   * getBoundStatementInsert
   * @param phonenumber
   * @param userid
   * @return Insert Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementInsert (
    Object phonenumber,
    Object userid) throws Exception {

    return
      this.getQuery(kInsertName).getBoundStatement(
        phonenumber,
        userid);
  }

  /**
   * executeAsyncInsert
   * executes Insert Query asynchronously
   * @param phonenumber
   * @param userid
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncInsert (
    Object phonenumber,
    Object userid) throws Exception {

    return
      this.getQuery(kInsertName).executeAsync(
        phonenumber,
        userid);
  }

  /**
   * executeSyncInsert
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes Insert Query synchronously
   * @param phonenumber
   * @param userid
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncInsert (
    Object phonenumber,
    Object userid) throws Exception {

    return
      this.getQuery(kInsertName).executeSync(
        phonenumber,
        userid);
  }

  // Query: Select
  // Description:
  //   selects a phone number's user id 
  // Parepared Statement:
  //   SELECT user_id FROM wa_auth.phone_numbers WHERE phone_number = 
  //   :phone_number; 

  /**
   * getQuerySelect
   * @return Select Query in the form of
   *           a Query Object
   * @throws Exception
   */
  public Query getQuerySelect (
    ) throws Exception {

    return this.getQuery(kSelectName);
  }

  /**
   * getQueryDispatchableSelect
   * @param phonenumber
   * @return Select Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableSelect (
    Object phonenumber) throws Exception {

    return
      this.getQueryDispatchable(
        kSelectName,
        phonenumber);
  }

  /**
   * getBoundStatementSelect
   * @param phonenumber
   * @return Select Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementSelect (
    Object phonenumber) throws Exception {

    return
      this.getQuery(kSelectName).getBoundStatement(
        phonenumber);
  }

  /**
   * executeAsyncSelect
   * executes Select Query asynchronously
   * @param phonenumber
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncSelect (
    Object phonenumber) throws Exception {

    return
      this.getQuery(kSelectName).executeAsync(
        phonenumber);
  }

  /**
   * executeSyncSelect
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes Select Query synchronously
   * @param phonenumber
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncSelect (
    Object phonenumber) throws Exception {

    return
      this.getQuery(kSelectName).executeSync(
        phonenumber);
  }

}
