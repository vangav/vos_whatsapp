// GENERATED using CqlScriptsGeneratorMain.java
// Keyspace: wa_blobs

CREATE KEYSPACE IF NOT EXISTS wa_blobs
  WITH replication = {
    'class': 'SimpleStrategy', 'replication_factor' : 1
};

USE wa_blobs;


CREATE TABLE IF NOT EXISTS messages (
  message_id uuid,
  message blob,
  PRIMARY KEY (message_id) )
  WITH CACHING = 'ALL';


