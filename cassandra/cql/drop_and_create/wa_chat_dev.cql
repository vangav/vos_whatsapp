// Keyspace: wa_chat

DROP KEYSPACE IF EXISTS wa_chat;

CREATE KEYSPACE wa_chat
  WITH replication = {
    'class': 'SimpleStrategy', 'replication_factor' : 1
};


USE wa_chat;

DROP TABLE IF EXISTS user_chats;

CREATE TABLE user_chats (
  user_id uuid,
  message_time bigint,
  sender_user_id uuid,
  receiver_user_id uuid,
  message_id uuid,
  PRIMARY KEY (user_id, message_time, sender_user_id) )
  WITH CACHING = 'ALL' AND
  CLUSTERING ORDER BY (message_time DESC);


