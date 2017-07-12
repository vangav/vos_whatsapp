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

package com.vangav.vos_whatsapp.cassandra_keyspaces.wa_users;

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
 * UsersInfo represents
 *   Table [users_info]
 *   in Keyspace [wa_users]
 * 
 * Name: users_info
 * Description:
 *   stores user information 
 * 
 * Columns:
 *   user_id : uuid
 *   name : varchar
 *   phone_number : varchar
 *   phone_type : varchar
 *   device_token : varchar

 * Partition Keys: user_id
 * Secondary Keys: 
 * Caching: ALL
 * Order By:

 * Queries:
 *   - Name: insert
 *   Description:
 *     inserts new user's data 
 *   Prepared Statement:
 *     INSERT INTO wa_users.users_info (user_id, name, phone_number, 
 *     phone_type, device_token) VALUES (:user_id, :name, 
 *     :phone_number, :phone_type, :device_token); 
 *   - Name: select_all
 *   Description:
 *     selects all user's data 
 *   Prepared Statement:
 *     SELECT name, phone_number, phone_type, device_token FROM 
 *     wa_users.users_info WHERE user_id = :user_id; 
 *   - Name: select_name
 *   Description:
 *     selects a user's name 
 *   Prepared Statement:
 *     SELECT name FROM wa_users.users_info WHERE user_id = :user_id; 
 *   - Name: select_phone_number
 *   Description:
 *     selects a user's phone number 
 *   Prepared Statement:
 *     SElECT phone_number FROM wa_users.users_info WHERE user_id = 
 *     :user_id; 
 *   - Name: select_phone_type
 *   Description:
 *     selects a user's phone_type 
 *   Prepared Statement:
 *     SELECT phone_type FROM wa_users.users_info WHERE user_id = 
 *     :user_id; 
 *   - Name: select_device_token
 *   Description:
 *     selects a user's device token 
 *   Prepared Statement:
 *     SELECT device_token FROM wa_users.users_info WHERE user_id = 
 *     :user_id; 
 * */
public class UsersInfo extends Table {

  private static final String kKeySpaceName =
    "wa_users";
  private static final String kTableName =
    "users_info";

  public static final String kUserIdColumnName =
    "user_id";
  public static final String kNameColumnName =
    "name";
  public static final String kPhoneNumberColumnName =
    "phone_number";
  public static final String kPhoneTypeColumnName =
    "phone_type";
  public static final String kDeviceTokenColumnName =
    "device_token";

  /**
   * Query:
   * Name: insert
   * Description:
   *   inserts new user's data 
   * Prepared Statement:
   *   INSERT INTO wa_users.users_info (user_id, name, phone_number, 
   *   phone_type, device_token) VALUES (:user_id, :name, 
   *   :phone_number, :phone_type, :device_token); 
   */
  private static final String kInsertName =
    "insert";
  private static final String kInsertDescription =
    "inserts new user's data ";
  private static final String kInsertPreparedStatement =
    "INSERT INTO wa_users.users_info (user_id, name, phone_number, "
    + "phone_type, device_token) VALUES (:user_id, :name, "
    + ":phone_number, :phone_type, :device_token); ";

  /**
   * Query:
   * Name: select_all
   * Description:
   *   selects all user's data 
   * Prepared Statement:
   *   SELECT name, phone_number, phone_type, device_token FROM 
   *   wa_users.users_info WHERE user_id = :user_id; 
   */
  private static final String kSelectAllName =
    "select_all";
  private static final String kSelectAllDescription =
    "selects all user's data ";
  private static final String kSelectAllPreparedStatement =
    "SELECT name, phone_number, phone_type, device_token FROM "
    + "wa_users.users_info WHERE user_id = :user_id; ";

  /**
   * Query:
   * Name: select_name
   * Description:
   *   selects a user's name 
   * Prepared Statement:
   *   SELECT name FROM wa_users.users_info WHERE user_id = :user_id; 
   */
  private static final String kSelectNameName =
    "select_name";
  private static final String kSelectNameDescription =
    "selects a user's name ";
  private static final String kSelectNamePreparedStatement =
    "SELECT name FROM wa_users.users_info WHERE user_id = :user_id; ";

  /**
   * Query:
   * Name: select_phone_number
   * Description:
   *   selects a user's phone number 
   * Prepared Statement:
   *   SElECT phone_number FROM wa_users.users_info WHERE user_id = 
   *   :user_id; 
   */
  private static final String kSelectPhoneNumberName =
    "select_phone_number";
  private static final String kSelectPhoneNumberDescription =
    "selects a user's phone number ";
  private static final String kSelectPhoneNumberPreparedStatement =
    "SElECT phone_number FROM wa_users.users_info WHERE user_id = :user_id; ";

  /**
   * Query:
   * Name: select_phone_type
   * Description:
   *   selects a user's phone_type 
   * Prepared Statement:
   *   SELECT phone_type FROM wa_users.users_info WHERE user_id = 
   *   :user_id; 
   */
  private static final String kSelectPhoneTypeName =
    "select_phone_type";
  private static final String kSelectPhoneTypeDescription =
    "selects a user's phone_type ";
  private static final String kSelectPhoneTypePreparedStatement =
    "SELECT phone_type FROM wa_users.users_info WHERE user_id = :user_id; ";

  /**
   * Query:
   * Name: select_device_token
   * Description:
   *   selects a user's device token 
   * Prepared Statement:
   *   SELECT device_token FROM wa_users.users_info WHERE user_id = 
   *   :user_id; 
   */
  private static final String kSelectDeviceTokenName =
    "select_device_token";
  private static final String kSelectDeviceTokenDescription =
    "selects a user's device token ";
  private static final String kSelectDeviceTokenPreparedStatement =
    "SELECT device_token FROM wa_users.users_info WHERE user_id = :user_id; ";

  /**
   * Constructor UsersInfo
   * @return new UsersInfo Object
   * @throws Exception
   */
  private UsersInfo () throws Exception {

    super (
      kKeySpaceName,
      kTableName,
      new Query (
        kInsertDescription,
        kInsertName,
        kInsertPreparedStatement),
      new Query (
        kSelectAllDescription,
        kSelectAllName,
        kSelectAllPreparedStatement),
      new Query (
        kSelectNameDescription,
        kSelectNameName,
        kSelectNamePreparedStatement),
      new Query (
        kSelectPhoneNumberDescription,
        kSelectPhoneNumberName,
        kSelectPhoneNumberPreparedStatement),
      new Query (
        kSelectPhoneTypeDescription,
        kSelectPhoneTypeName,
        kSelectPhoneTypePreparedStatement),
      new Query (
        kSelectDeviceTokenDescription,
        kSelectDeviceTokenName,
        kSelectDeviceTokenPreparedStatement));
  }

  private static UsersInfo instance = null;

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

      instance = new UsersInfo();
    }
  }

  /**
   * i
   * @return singleton static instance of UsersInfo
   * @throws Exception
   */
  public static UsersInfo i () throws Exception {

    if (instance == null) {

      instance = new UsersInfo();
    }

    return instance;
  }

  // Query: Insert
  // Description:
  //   inserts new user's data 
  // Parepared Statement:
  //   INSERT INTO wa_users.users_info (user_id, name, phone_number, 
  //   phone_type, device_token) VALUES (:user_id, :name, 
  //   :phone_number, :phone_type, :device_token); 

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
   * @param userid
   * @param name
   * @param phonenumber
   * @param phonetype
   * @param devicetoken
   * @return Insert Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableInsert (
    Object userid,
    Object name,
    Object phonenumber,
    Object phonetype,
    Object devicetoken) throws Exception {

    return
      this.getQueryDispatchable(
        kInsertName,
        userid,
        name,
        phonenumber,
        phonetype,
        devicetoken);
  }

  /**
   * getBoundStatementInsert
   * @param userid
   * @param name
   * @param phonenumber
   * @param phonetype
   * @param devicetoken
   * @return Insert Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementInsert (
    Object userid,
    Object name,
    Object phonenumber,
    Object phonetype,
    Object devicetoken) throws Exception {

    return
      this.getQuery(kInsertName).getBoundStatement(
        userid,
        name,
        phonenumber,
        phonetype,
        devicetoken);
  }

  /**
   * executeAsyncInsert
   * executes Insert Query asynchronously
   * @param userid
   * @param name
   * @param phonenumber
   * @param phonetype
   * @param devicetoken
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncInsert (
    Object userid,
    Object name,
    Object phonenumber,
    Object phonetype,
    Object devicetoken) throws Exception {

    return
      this.getQuery(kInsertName).executeAsync(
        userid,
        name,
        phonenumber,
        phonetype,
        devicetoken);
  }

  /**
   * executeSyncInsert
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes Insert Query synchronously
   * @param userid
   * @param name
   * @param phonenumber
   * @param phonetype
   * @param devicetoken
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncInsert (
    Object userid,
    Object name,
    Object phonenumber,
    Object phonetype,
    Object devicetoken) throws Exception {

    return
      this.getQuery(kInsertName).executeSync(
        userid,
        name,
        phonenumber,
        phonetype,
        devicetoken);
  }

  // Query: SelectAll
  // Description:
  //   selects all user's data 
  // Parepared Statement:
  //   SELECT name, phone_number, phone_type, device_token FROM 
  //   wa_users.users_info WHERE user_id = :user_id; 

  /**
   * getQuerySelectAll
   * @return SelectAll Query in the form of
   *           a Query Object
   * @throws Exception
   */
  public Query getQuerySelectAll (
    ) throws Exception {

    return this.getQuery(kSelectAllName);
  }

  /**
   * getQueryDispatchableSelectAll
   * @param userid
   * @return SelectAll Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableSelectAll (
    Object userid) throws Exception {

    return
      this.getQueryDispatchable(
        kSelectAllName,
        userid);
  }

  /**
   * getBoundStatementSelectAll
   * @param userid
   * @return SelectAll Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementSelectAll (
    Object userid) throws Exception {

    return
      this.getQuery(kSelectAllName).getBoundStatement(
        userid);
  }

  /**
   * executeAsyncSelectAll
   * executes SelectAll Query asynchronously
   * @param userid
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncSelectAll (
    Object userid) throws Exception {

    return
      this.getQuery(kSelectAllName).executeAsync(
        userid);
  }

  /**
   * executeSyncSelectAll
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes SelectAll Query synchronously
   * @param userid
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncSelectAll (
    Object userid) throws Exception {

    return
      this.getQuery(kSelectAllName).executeSync(
        userid);
  }

  // Query: SelectName
  // Description:
  //   selects a user's name 
  // Parepared Statement:
  //   SELECT name FROM wa_users.users_info WHERE user_id = :user_id; 

  /**
   * getQuerySelectName
   * @return SelectName Query in the form of
   *           a Query Object
   * @throws Exception
   */
  public Query getQuerySelectName (
    ) throws Exception {

    return this.getQuery(kSelectNameName);
  }

  /**
   * getQueryDispatchableSelectName
   * @param userid
   * @return SelectName Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableSelectName (
    Object userid) throws Exception {

    return
      this.getQueryDispatchable(
        kSelectNameName,
        userid);
  }

  /**
   * getBoundStatementSelectName
   * @param userid
   * @return SelectName Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementSelectName (
    Object userid) throws Exception {

    return
      this.getQuery(kSelectNameName).getBoundStatement(
        userid);
  }

  /**
   * executeAsyncSelectName
   * executes SelectName Query asynchronously
   * @param userid
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncSelectName (
    Object userid) throws Exception {

    return
      this.getQuery(kSelectNameName).executeAsync(
        userid);
  }

  /**
   * executeSyncSelectName
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes SelectName Query synchronously
   * @param userid
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncSelectName (
    Object userid) throws Exception {

    return
      this.getQuery(kSelectNameName).executeSync(
        userid);
  }

  // Query: SelectPhoneNumber
  // Description:
  //   selects a user's phone number 
  // Parepared Statement:
  //   SElECT phone_number FROM wa_users.users_info WHERE user_id = 
  //   :user_id; 

  /**
   * getQuerySelectPhoneNumber
   * @return SelectPhoneNumber Query in the form of
   *           a Query Object
   * @throws Exception
   */
  public Query getQuerySelectPhoneNumber (
    ) throws Exception {

    return this.getQuery(kSelectPhoneNumberName);
  }

  /**
   * getQueryDispatchableSelectPhoneNumber
   * @param userid
   * @return SelectPhoneNumber Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableSelectPhoneNumber (
    Object userid) throws Exception {

    return
      this.getQueryDispatchable(
        kSelectPhoneNumberName,
        userid);
  }

  /**
   * getBoundStatementSelectPhoneNumber
   * @param userid
   * @return SelectPhoneNumber Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementSelectPhoneNumber (
    Object userid) throws Exception {

    return
      this.getQuery(kSelectPhoneNumberName).getBoundStatement(
        userid);
  }

  /**
   * executeAsyncSelectPhoneNumber
   * executes SelectPhoneNumber Query asynchronously
   * @param userid
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncSelectPhoneNumber (
    Object userid) throws Exception {

    return
      this.getQuery(kSelectPhoneNumberName).executeAsync(
        userid);
  }

  /**
   * executeSyncSelectPhoneNumber
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes SelectPhoneNumber Query synchronously
   * @param userid
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncSelectPhoneNumber (
    Object userid) throws Exception {

    return
      this.getQuery(kSelectPhoneNumberName).executeSync(
        userid);
  }

  // Query: SelectPhoneType
  // Description:
  //   selects a user's phone_type 
  // Parepared Statement:
  //   SELECT phone_type FROM wa_users.users_info WHERE user_id = 
  //   :user_id; 

  /**
   * getQuerySelectPhoneType
   * @return SelectPhoneType Query in the form of
   *           a Query Object
   * @throws Exception
   */
  public Query getQuerySelectPhoneType (
    ) throws Exception {

    return this.getQuery(kSelectPhoneTypeName);
  }

  /**
   * getQueryDispatchableSelectPhoneType
   * @param userid
   * @return SelectPhoneType Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableSelectPhoneType (
    Object userid) throws Exception {

    return
      this.getQueryDispatchable(
        kSelectPhoneTypeName,
        userid);
  }

  /**
   * getBoundStatementSelectPhoneType
   * @param userid
   * @return SelectPhoneType Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementSelectPhoneType (
    Object userid) throws Exception {

    return
      this.getQuery(kSelectPhoneTypeName).getBoundStatement(
        userid);
  }

  /**
   * executeAsyncSelectPhoneType
   * executes SelectPhoneType Query asynchronously
   * @param userid
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncSelectPhoneType (
    Object userid) throws Exception {

    return
      this.getQuery(kSelectPhoneTypeName).executeAsync(
        userid);
  }

  /**
   * executeSyncSelectPhoneType
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes SelectPhoneType Query synchronously
   * @param userid
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncSelectPhoneType (
    Object userid) throws Exception {

    return
      this.getQuery(kSelectPhoneTypeName).executeSync(
        userid);
  }

  // Query: SelectDeviceToken
  // Description:
  //   selects a user's device token 
  // Parepared Statement:
  //   SELECT device_token FROM wa_users.users_info WHERE user_id = 
  //   :user_id; 

  /**
   * getQuerySelectDeviceToken
   * @return SelectDeviceToken Query in the form of
   *           a Query Object
   * @throws Exception
   */
  public Query getQuerySelectDeviceToken (
    ) throws Exception {

    return this.getQuery(kSelectDeviceTokenName);
  }

  /**
   * getQueryDispatchableSelectDeviceToken
   * @param userid
   * @return SelectDeviceToken Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableSelectDeviceToken (
    Object userid) throws Exception {

    return
      this.getQueryDispatchable(
        kSelectDeviceTokenName,
        userid);
  }

  /**
   * getBoundStatementSelectDeviceToken
   * @param userid
   * @return SelectDeviceToken Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementSelectDeviceToken (
    Object userid) throws Exception {

    return
      this.getQuery(kSelectDeviceTokenName).getBoundStatement(
        userid);
  }

  /**
   * executeAsyncSelectDeviceToken
   * executes SelectDeviceToken Query asynchronously
   * @param userid
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncSelectDeviceToken (
    Object userid) throws Exception {

    return
      this.getQuery(kSelectDeviceTokenName).executeAsync(
        userid);
  }

  /**
   * executeSyncSelectDeviceToken
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes SelectDeviceToken Query synchronously
   * @param userid
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncSelectDeviceToken (
    Object userid) throws Exception {

    return
      this.getQuery(kSelectDeviceTokenName).executeSync(
        userid);
  }

}
