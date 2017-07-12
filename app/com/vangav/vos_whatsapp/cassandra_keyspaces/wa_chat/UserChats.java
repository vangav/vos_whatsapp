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

package com.vangav.vos_whatsapp.cassandra_keyspaces.wa_chat;

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
 * UserChats represents
 *   Table [user_chats]
 *   in Keyspace [wa_chat]
 * 
 * Name: user_chats
 * Description:
 *   used to stores all chat messages per-user 
 * 
 * Columns:
 *   user_id : uuid
 *   message_time : bigint
 *   sender_user_id : uuid
 *   receiver_user_id : uuid
 *   message_id : uuid

 * Partition Keys: user_id, message_time, sender_user_id
 * Secondary Keys: 
 * Caching: ALL
 * Order By:
 *   message_time : DESC

 * Queries:
 *   - Name: insert
 *   Description:
 *     inserts a new message for a user 
 *   Prepared Statement:
 *     INSERT INTO wa_chat.user_chats (user_id, message_time, 
 *     sender_user_id, receiver_user_id, message_id) VALUES 
 *     (:user_id, :message_time, :sender_user_id, 
 *     :receiver_user_id, :message_id); 
 *   - Name: select_recent
 *   Description:
 *     selects recent messages 
 *   Prepared Statement:
 *     SELECT message_time, sender_user_id, receiver_user_id, message_id 
 *     FROM wa_chat.user_chats WHERE user_id = :user_id AND 
 *     message_time > :message_time; 
 *   - Name: select_all
 *   Description:
 *     selects all user's messages 
 *   Prepared Statement:
 *     SELECT message_time, sender_user_id, receiver_user_id, message_id 
 *     FROM wa_chat.user_chats WHERE user_id = :user_id; 
 * */
public class UserChats extends Table {

  private static final String kKeySpaceName =
    "wa_chat";
  private static final String kTableName =
    "user_chats";

  public static final String kUserIdColumnName =
    "user_id";
  public static final String kMessageTimeColumnName =
    "message_time";
  public static final String kSenderUserIdColumnName =
    "sender_user_id";
  public static final String kReceiverUserIdColumnName =
    "receiver_user_id";
  public static final String kMessageIdColumnName =
    "message_id";

  /**
   * Query:
   * Name: insert
   * Description:
   *   inserts a new message for a user 
   * Prepared Statement:
   *   INSERT INTO wa_chat.user_chats (user_id, message_time, 
   *   sender_user_id, receiver_user_id, message_id) VALUES 
   *   (:user_id, :message_time, :sender_user_id, 
   *   :receiver_user_id, :message_id); 
   */
  private static final String kInsertName =
    "insert";
  private static final String kInsertDescription =
    "inserts a new message for a user ";
  private static final String kInsertPreparedStatement =
    "INSERT INTO wa_chat.user_chats (user_id, message_time, sender_user_id, "
    + "receiver_user_id, message_id) VALUES (:user_id, :message_time, "
    + ":sender_user_id, :receiver_user_id, :message_id); ";

  /**
   * Query:
   * Name: select_recent
   * Description:
   *   selects recent messages 
   * Prepared Statement:
   *   SELECT message_time, sender_user_id, receiver_user_id, message_id 
   *   FROM wa_chat.user_chats WHERE user_id = :user_id AND 
   *   message_time > :message_time; 
   */
  private static final String kSelectRecentName =
    "select_recent";
  private static final String kSelectRecentDescription =
    "selects recent messages ";
  private static final String kSelectRecentPreparedStatement =
    "SELECT message_time, sender_user_id, receiver_user_id, message_id FROM "
    + "wa_chat.user_chats WHERE user_id = :user_id AND message_time > "
    + ":message_time; ";

  /**
   * Query:
   * Name: select_all
   * Description:
   *   selects all user's messages 
   * Prepared Statement:
   *   SELECT message_time, sender_user_id, receiver_user_id, message_id 
   *   FROM wa_chat.user_chats WHERE user_id = :user_id; 
   */
  private static final String kSelectAllName =
    "select_all";
  private static final String kSelectAllDescription =
    "selects all user's messages ";
  private static final String kSelectAllPreparedStatement =
    "SELECT message_time, sender_user_id, receiver_user_id, message_id FROM "
    + "wa_chat.user_chats WHERE user_id = :user_id; ";

  /**
   * Constructor UserChats
   * @return new UserChats Object
   * @throws Exception
   */
  private UserChats () throws Exception {

    super (
      kKeySpaceName,
      kTableName,
      new Query (
        kInsertDescription,
        kInsertName,
        kInsertPreparedStatement),
      new Query (
        kSelectRecentDescription,
        kSelectRecentName,
        kSelectRecentPreparedStatement),
      new Query (
        kSelectAllDescription,
        kSelectAllName,
        kSelectAllPreparedStatement));
  }

  private static UserChats instance = null;

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

      instance = new UserChats();
    }
  }

  /**
   * i
   * @return singleton static instance of UserChats
   * @throws Exception
   */
  public static UserChats i () throws Exception {

    if (instance == null) {

      instance = new UserChats();
    }

    return instance;
  }

  // Query: Insert
  // Description:
  //   inserts a new message for a user 
  // Parepared Statement:
  //   INSERT INTO wa_chat.user_chats (user_id, message_time, 
  //   sender_user_id, receiver_user_id, message_id) VALUES 
  //   (:user_id, :message_time, :sender_user_id, 
  //   :receiver_user_id, :message_id); 

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
   * @param messagetime
   * @param senderuserid
   * @param receiveruserid
   * @param messageid
   * @return Insert Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableInsert (
    Object userid,
    Object messagetime,
    Object senderuserid,
    Object receiveruserid,
    Object messageid) throws Exception {

    return
      this.getQueryDispatchable(
        kInsertName,
        userid,
        messagetime,
        senderuserid,
        receiveruserid,
        messageid);
  }

  /**
   * getBoundStatementInsert
   * @param userid
   * @param messagetime
   * @param senderuserid
   * @param receiveruserid
   * @param messageid
   * @return Insert Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementInsert (
    Object userid,
    Object messagetime,
    Object senderuserid,
    Object receiveruserid,
    Object messageid) throws Exception {

    return
      this.getQuery(kInsertName).getBoundStatement(
        userid,
        messagetime,
        senderuserid,
        receiveruserid,
        messageid);
  }

  /**
   * executeAsyncInsert
   * executes Insert Query asynchronously
   * @param userid
   * @param messagetime
   * @param senderuserid
   * @param receiveruserid
   * @param messageid
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncInsert (
    Object userid,
    Object messagetime,
    Object senderuserid,
    Object receiveruserid,
    Object messageid) throws Exception {

    return
      this.getQuery(kInsertName).executeAsync(
        userid,
        messagetime,
        senderuserid,
        receiveruserid,
        messageid);
  }

  /**
   * executeSyncInsert
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes Insert Query synchronously
   * @param userid
   * @param messagetime
   * @param senderuserid
   * @param receiveruserid
   * @param messageid
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncInsert (
    Object userid,
    Object messagetime,
    Object senderuserid,
    Object receiveruserid,
    Object messageid) throws Exception {

    return
      this.getQuery(kInsertName).executeSync(
        userid,
        messagetime,
        senderuserid,
        receiveruserid,
        messageid);
  }

  // Query: SelectRecent
  // Description:
  //   selects recent messages 
  // Parepared Statement:
  //   SELECT message_time, sender_user_id, receiver_user_id, message_id 
  //   FROM wa_chat.user_chats WHERE user_id = :user_id AND 
  //   message_time > :message_time; 

  /**
   * getQuerySelectRecent
   * @return SelectRecent Query in the form of
   *           a Query Object
   * @throws Exception
   */
  public Query getQuerySelectRecent (
    ) throws Exception {

    return this.getQuery(kSelectRecentName);
  }

  /**
   * getQueryDispatchableSelectRecent
   * @param userid
   * @param messagetime
   * @return SelectRecent Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableSelectRecent (
    Object userid,
    Object messagetime) throws Exception {

    return
      this.getQueryDispatchable(
        kSelectRecentName,
        userid,
        messagetime);
  }

  /**
   * getBoundStatementSelectRecent
   * @param userid
   * @param messagetime
   * @return SelectRecent Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementSelectRecent (
    Object userid,
    Object messagetime) throws Exception {

    return
      this.getQuery(kSelectRecentName).getBoundStatement(
        userid,
        messagetime);
  }

  /**
   * executeAsyncSelectRecent
   * executes SelectRecent Query asynchronously
   * @param userid
   * @param messagetime
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncSelectRecent (
    Object userid,
    Object messagetime) throws Exception {

    return
      this.getQuery(kSelectRecentName).executeAsync(
        userid,
        messagetime);
  }

  /**
   * executeSyncSelectRecent
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes SelectRecent Query synchronously
   * @param userid
   * @param messagetime
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncSelectRecent (
    Object userid,
    Object messagetime) throws Exception {

    return
      this.getQuery(kSelectRecentName).executeSync(
        userid,
        messagetime);
  }

  // Query: SelectAll
  // Description:
  //   selects all user's messages 
  // Parepared Statement:
  //   SELECT message_time, sender_user_id, receiver_user_id, message_id 
  //   FROM wa_chat.user_chats WHERE user_id = :user_id; 

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

}
