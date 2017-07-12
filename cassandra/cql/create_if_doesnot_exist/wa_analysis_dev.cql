// GENERATED using CqlScriptsGeneratorMain.java
// Keyspace: wa_analysis

CREATE KEYSPACE IF NOT EXISTS wa_analysis
  WITH replication = {
    'class': 'SimpleStrategy', 'replication_factor' : 1
};

USE wa_analysis;


CREATE TABLE IF NOT EXISTS users_count (
  year_month_day varchar,
  counter_value counter,
  PRIMARY KEY (year_month_day) )
  WITH CACHING = 'ALL';


CREATE TABLE IF NOT EXISTS messages_count (
  year_month_day varchar,
  counter_value counter,
  PRIMARY KEY (year_month_day) )
  WITH CACHING = 'ALL';


