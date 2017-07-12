// GENERATED using CqlScriptsGeneratorMain.java
// Keyspace: wa_users

CREATE KEYSPACE IF NOT EXISTS wa_users
  WITH replication = {
    'class': 'SimpleStrategy', 'replication_factor' : 1
};

USE wa_users;


CREATE TABLE IF NOT EXISTS users_info (
  user_id uuid,
  name varchar,
  phone_number varchar,
  phone_type varchar,
  device_token varchar,
  PRIMARY KEY (user_id) )
  WITH CACHING = 'ALL';


