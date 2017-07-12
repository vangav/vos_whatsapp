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

package com.vangav.vos_whatsapp.cassandra_keyspaces.wa_blobs;

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
 * Messages represents
 *   Table [messages]
 *   in Keyspace [wa_blobs]
 * 
 * Name: messages
 * Description:
 *   used to store all messages 
 * 
 * Columns:
 *   message_id : uuid
 *   message : blob

 * Partition Keys: message_id
 * Secondary Keys: 
 * Caching: ALL
 * Order By:

 * Queries:
 *   - Name: insert
 *   Description:
 *     inserts new messages 
 *   Prepared Statement:
 *     INSERT INTO wa_blobs.messages (message_id, message) VALUES 
 *     (:message_id, :message); 
 *   - Name: select
 *   Description:
 *     selects a message 
 *   Prepared Statement:
 *     SELECT message FROM wa_blobs.messages WHERE message_id = 
 *     :message_id; 
 * */
public class Messages extends Table {

  private static final String kKeySpaceName =
    "wa_blobs";
  private static final String kTableName =
    "messages";

  public static final String kMessageIdColumnName =
    "message_id";
  public static final String kMessageColumnName =
    "message";

  /**
   * Query:
   * Name: insert
   * Description:
   *   inserts new messages 
   * Prepared Statement:
   *   INSERT INTO wa_blobs.messages (message_id, message) VALUES 
   *   (:message_id, :message); 
   */
  private static final String kInsertName =
    "insert";
  private static final String kInsertDescription =
    "inserts new messages ";
  private static final String kInsertPreparedStatement =
    "INSERT INTO wa_blobs.messages (message_id, message) VALUES "
    + "(:message_id, :message); ";

  /**
   * Query:
   * Name: select
   * Description:
   *   selects a message 
   * Prepared Statement:
   *   SELECT message FROM wa_blobs.messages WHERE message_id = 
   *   :message_id; 
   */
  private static final String kSelectName =
    "select";
  private static final String kSelectDescription =
    "selects a message ";
  private static final String kSelectPreparedStatement =
    "SELECT message FROM wa_blobs.messages WHERE message_id = :message_id; ";

  /**
   * Constructor Messages
   * @return new Messages Object
   * @throws Exception
   */
  private Messages () throws Exception {

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

  private static Messages instance = null;

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

      instance = new Messages();
    }
  }

  /**
   * i
   * @return singleton static instance of Messages
   * @throws Exception
   */
  public static Messages i () throws Exception {

    if (instance == null) {

      instance = new Messages();
    }

    return instance;
  }

  // Query: Insert
  // Description:
  //   inserts new messages 
  // Parepared Statement:
  //   INSERT INTO wa_blobs.messages (message_id, message) VALUES 
  //   (:message_id, :message); 

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
   * @param messageid
   * @param message
   * @return Insert Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableInsert (
    Object messageid,
    Object message) throws Exception {

    return
      this.getQueryDispatchable(
        kInsertName,
        messageid,
        message);
  }

  /**
   * getBoundStatementInsert
   * @param messageid
   * @param message
   * @return Insert Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementInsert (
    Object messageid,
    Object message) throws Exception {

    return
      this.getQuery(kInsertName).getBoundStatement(
        messageid,
        message);
  }

  /**
   * executeAsyncInsert
   * executes Insert Query asynchronously
   * @param messageid
   * @param message
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncInsert (
    Object messageid,
    Object message) throws Exception {

    return
      this.getQuery(kInsertName).executeAsync(
        messageid,
        message);
  }

  /**
   * executeSyncInsert
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes Insert Query synchronously
   * @param messageid
   * @param message
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncInsert (
    Object messageid,
    Object message) throws Exception {

    return
      this.getQuery(kInsertName).executeSync(
        messageid,
        message);
  }

  // Query: Select
  // Description:
  //   selects a message 
  // Parepared Statement:
  //   SELECT message FROM wa_blobs.messages WHERE message_id = 
  //   :message_id; 

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
   * @param messageid
   * @return Select Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableSelect (
    Object messageid) throws Exception {

    return
      this.getQueryDispatchable(
        kSelectName,
        messageid);
  }

  /**
   * getBoundStatementSelect
   * @param messageid
   * @return Select Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementSelect (
    Object messageid) throws Exception {

    return
      this.getQuery(kSelectName).getBoundStatement(
        messageid);
  }

  /**
   * executeAsyncSelect
   * executes Select Query asynchronously
   * @param messageid
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncSelect (
    Object messageid) throws Exception {

    return
      this.getQuery(kSelectName).executeAsync(
        messageid);
  }

  /**
   * executeSyncSelect
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes Select Query synchronously
   * @param messageid
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncSelect (
    Object messageid) throws Exception {

    return
      this.getQuery(kSelectName).executeSync(
        messageid);
  }

}
