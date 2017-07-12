// GENERATED using CqlScriptsGeneratorMain.java
// Keyspace: wa_auth

CREATE KEYSPACE IF NOT EXISTS wa_auth
  WITH replication = {
    'class': 'SimpleStrategy', 'replication_factor' : 1
};

USE wa_auth;


CREATE TABLE IF NOT EXISTS phone_numbers (
  phone_number varchar,
  user_id uuid,
  PRIMARY KEY (phone_number) )
  WITH CACHING = 'ALL';


CREATE TABLE IF NOT EXISTS auth_creds (
  user_id uuid,
  password varchar,
  PRIMARY KEY (user_id) )
  WITH CACHING = 'ALL';


