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
 * AuthCreds represents
 *   Table [auth_creds]
 *   in Keyspace [wa_auth]
 * 
 * Name: auth_creds
 * Description:
 *   used to map users' ids to generated passwords for authenticating 
 *   users and requests 
 * 
 * Columns:
 *   user_id : uuid
 *   password : varchar

 * Partition Keys: user_id
 * Secondary Keys: 
 * Caching: ALL
 * Order By:

 * Queries:
 *   - Name: insert
 *   Description:
 *     inserts new user's user id and password 
 *   Prepared Statement:
 *     INSERT INTO wa_auth.auth_creds (user_id, password) VALUES 
 *     (:user_id, :password); 
 *   - Name: select
 *   Description:
 *     selects a user id's password 
 *   Prepared Statement:
 *     SELECT password FROM wa_auth.auth_creds WHERE user_id = :user_id; 
 * */
public class AuthCreds extends Table {

  private static final String kKeySpaceName =
    "wa_auth";
  private static final String kTableName =
    "auth_creds";

  public static final String kUserIdColumnName =
    "user_id";
  public static final String kPasswordColumnName =
    "password";

  /**
   * Query:
   * Name: insert
   * Description:
   *   inserts new user's user id and password 
   * Prepared Statement:
   *   INSERT INTO wa_auth.auth_creds (user_id, password) VALUES 
   *   (:user_id, :password); 
   */
  private static final String kInsertName =
    "insert";
  private static final String kInsertDescription =
    "inserts new user's user id and password ";
  private static final String kInsertPreparedStatement =
    "INSERT INTO wa_auth.auth_creds (user_id, password) VALUES (:user_id, "
    + ":password); ";

  /**
   * Query:
   * Name: select
   * Description:
   *   selects a user id's password 
   * Prepared Statement:
   *   SELECT password FROM wa_auth.auth_creds WHERE user_id = :user_id; 
   */
  private static final String kSelectName =
    "select";
  private static final String kSelectDescription =
    "selects a user id's password ";
  private static final String kSelectPreparedStatement =
    "SELECT password FROM wa_auth.auth_creds WHERE user_id = :user_id; ";

  /**
   * Constructor AuthCreds
   * @return new AuthCreds Object
   * @throws Exception
   */
  private AuthCreds () throws Exception {

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

  private static AuthCreds instance = null;

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

      instance = new AuthCreds();
    }
  }

  /**
   * i
   * @return singleton static instance of AuthCreds
   * @throws Exception
   */
  public static AuthCreds i () throws Exception {

    if (instance == null) {

      instance = new AuthCreds();
    }

    return instance;
  }

  // Query: Insert
  // Description:
  //   inserts new user's user id and password 
  // Parepared Statement:
  //   INSERT INTO wa_auth.auth_creds (user_id, password) VALUES 
  //   (:user_id, :password); 

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
   * @param password
   * @return Insert Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableInsert (
    Object userid,
    Object password) throws Exception {

    return
      this.getQueryDispatchable(
        kInsertName,
        userid,
        password);
  }

  /**
   * getBoundStatementInsert
   * @param userid
   * @param password
   * @return Insert Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementInsert (
    Object userid,
    Object password) throws Exception {

    return
      this.getQuery(kInsertName).getBoundStatement(
        userid,
        password);
  }

  /**
   * executeAsyncInsert
   * executes Insert Query asynchronously
   * @param userid
   * @param password
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncInsert (
    Object userid,
    Object password) throws Exception {

    return
      this.getQuery(kInsertName).executeAsync(
        userid,
        password);
  }

  /**
   * executeSyncInsert
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes Insert Query synchronously
   * @param userid
   * @param password
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncInsert (
    Object userid,
    Object password) throws Exception {

    return
      this.getQuery(kInsertName).executeSync(
        userid,
        password);
  }

  // Query: Select
  // Description:
  //   selects a user id's password 
  // Parepared Statement:
  //   SELECT password FROM wa_auth.auth_creds WHERE user_id = :user_id; 

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
   * @param userid
   * @return Select Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableSelect (
    Object userid) throws Exception {

    return
      this.getQueryDispatchable(
        kSelectName,
        userid);
  }

  /**
   * getBoundStatementSelect
   * @param userid
   * @return Select Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementSelect (
    Object userid) throws Exception {

    return
      this.getQuery(kSelectName).getBoundStatement(
        userid);
  }

  /**
   * executeAsyncSelect
   * executes Select Query asynchronously
   * @param userid
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncSelect (
    Object userid) throws Exception {

    return
      this.getQuery(kSelectName).executeAsync(
        userid);
  }

  /**
   * executeSyncSelect
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes Select Query synchronously
   * @param userid
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncSelect (
    Object userid) throws Exception {

    return
      this.getQuery(kSelectName).executeSync(
        userid);
  }

}
