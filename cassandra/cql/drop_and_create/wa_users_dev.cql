// Keyspace: wa_users

DROP KEYSPACE IF EXISTS wa_users;

CREATE KEYSPACE wa_users
  WITH replication = {
    'class': 'SimpleStrategy', 'replication_factor' : 1
};


USE wa_users;

DROP TABLE IF EXISTS users_info;

CREATE TABLE users_info (
  user_id uuid,
  name varchar,
  phone_number varchar,
  phone_type varchar,
  device_token varchar,
  PRIMARY KEY (user_id) )
  WITH CACHING = 'ALL';


