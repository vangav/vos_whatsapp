// Keyspace: wa_auth

DROP KEYSPACE IF EXISTS wa_auth;

CREATE KEYSPACE wa_auth
  WITH replication = {
    'class': 'SimpleStrategy', 'replication_factor' : 1
};


USE wa_auth;

DROP TABLE IF EXISTS phone_numbers;

CREATE TABLE phone_numbers (
  phone_number varchar,
  user_id uuid,
  PRIMARY KEY (phone_number) )
  WITH CACHING = 'ALL';


DROP TABLE IF EXISTS auth_creds;

CREATE TABLE auth_creds (
  user_id uuid,
  password varchar,
  PRIMARY KEY (user_id) )
  WITH CACHING = 'ALL';


