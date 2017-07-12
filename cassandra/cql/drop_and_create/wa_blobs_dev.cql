// Keyspace: wa_blobs

DROP KEYSPACE IF EXISTS wa_blobs;

CREATE KEYSPACE wa_blobs
  WITH replication = {
    'class': 'SimpleStrategy', 'replication_factor' : 1
};


USE wa_blobs;

DROP TABLE IF EXISTS messages;

CREATE TABLE messages (
  message_id uuid,
  message blob,
  PRIMARY KEY (message_id) )
  WITH CACHING = 'ALL';


