// Keyspace: wa_analysis

DROP KEYSPACE IF EXISTS wa_analysis;

CREATE KEYSPACE wa_analysis
  WITH replication = {
    'class': 'SimpleStrategy', 'replication_factor' : 1
};


USE wa_analysis;

DROP TABLE IF EXISTS users_count;

CREATE TABLE users_count (
  year_month_day varchar,
  counter_value counter,
  PRIMARY KEY (year_month_day) )
  WITH CACHING = 'ALL';


DROP TABLE IF EXISTS messages_count;

CREATE TABLE messages_count (
  year_month_day varchar,
  counter_value counter,
  PRIMARY KEY (year_month_day) )
  WITH CACHING = 'ALL';


