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

package com.vangav.vos_whatsapp.cassandra_keyspaces.wa_analysis;

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
 * UsersCount represents
 *   Table [users_count]
 *   in Keyspace [wa_analysis]
 * 
 * Name: users_count
 * Description:
 *   counts new users per-day 
 * 
 * Columns:
 *   year_month_day : varchar
 *   counter_value : counter

 * Partition Keys: year_month_day
 * Secondary Keys: 
 * Caching: ALL
 * Order By:

 * Queries:
 *   - Name: increment
 *   Description:
 *     increments the number of signed up users on a day 
 *   Prepared Statement:
 *     UPDATE wa_analysis.users_count SET counter_value = counter_value + 
 *     1 WHERE year_month_day = :year_month_day; 
 * */
public class UsersCount extends Table {

  private static final String kKeySpaceName =
    "wa_analysis";
  private static final String kTableName =
    "users_count";

  public static final String kYearMonthDayColumnName =
    "year_month_day";
  public static final String kCounterValueColumnName =
    "counter_value";

  /**
   * Query:
   * Name: increment
   * Description:
   *   increments the number of signed up users on a day 
   * Prepared Statement:
   *   UPDATE wa_analysis.users_count SET counter_value = counter_value + 
   *   1 WHERE year_month_day = :year_month_day; 
   */
  private static final String kIncrementName =
    "increment";
  private static final String kIncrementDescription =
    "increments the number of signed up users on a day ";
  private static final String kIncrementPreparedStatement =
    "UPDATE wa_analysis.users_count SET counter_value = counter_value + 1 "
    + "WHERE year_month_day = :year_month_day; ";

  /**
   * Constructor UsersCount
   * @return new UsersCount Object
   * @throws Exception
   */
  private UsersCount () throws Exception {

    super (
      kKeySpaceName,
      kTableName,
      new Query (
        kIncrementDescription,
        kIncrementName,
        kIncrementPreparedStatement));
  }

  private static UsersCount instance = null;

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

      instance = new UsersCount();
    }
  }

  /**
   * i
   * @return singleton static instance of UsersCount
   * @throws Exception
   */
  public static UsersCount i () throws Exception {

    if (instance == null) {

      instance = new UsersCount();
    }

    return instance;
  }

  // Query: Increment
  // Description:
  //   increments the number of signed up users on a day 
  // Parepared Statement:
  //   UPDATE wa_analysis.users_count SET counter_value = counter_value + 
  //   1 WHERE year_month_day = :year_month_day; 

  /**
   * getQueryIncrement
   * @return Increment Query in the form of
   *           a Query Object
   * @throws Exception
   */
  public Query getQueryIncrement (
    ) throws Exception {

    return this.getQuery(kIncrementName);
  }

  /**
   * getQueryDispatchableIncrement
   * @param yearmonthday
   * @return Increment Query in the form of
   *           a QueryDisbatchable Object
   *           (e.g.: to be passed on to a worker instance)
   * @throws Exception
   */
  public QueryDispatchable getQueryDispatchableIncrement (
    Object yearmonthday) throws Exception {

    return
      this.getQueryDispatchable(
        kIncrementName,
        yearmonthday);
  }

  /**
   * getBoundStatementIncrement
   * @param yearmonthday
   * @return Increment Query in the form of
   *           a BoundStatement ready for execution or to be added to
   *           a BatchStatement
   * @throws Exception
   */
  public BoundStatement getBoundStatementIncrement (
    Object yearmonthday) throws Exception {

    return
      this.getQuery(kIncrementName).getBoundStatement(
        yearmonthday);
  }

  /**
   * executeAsyncIncrement
   * executes Increment Query asynchronously
   * @param yearmonthday
   * @return ResultSetFuture
   * @throws Exception
   */
  public ResultSetFuture executeAsyncIncrement (
    Object yearmonthday) throws Exception {

    return
      this.getQuery(kIncrementName).executeAsync(
        yearmonthday);
  }

  /**
   * executeSyncIncrement
   * BLOCKING-METHOD: blocks till the ResultSet is ready
   * executes Increment Query synchronously
   * @param yearmonthday
   * @return ResultSet
   * @throws Exception
   */
  public ResultSet executeSyncIncrement (
    Object yearmonthday) throws Exception {

    return
      this.getQuery(kIncrementName).executeSync(
        yearmonthday);
  }

}
