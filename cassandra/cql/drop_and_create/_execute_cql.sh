#!/bin/bash

# used to execute a cassandra CQL script
# IMPORTANT: CQL script file name must be passed as an argument

if [ "$1" -eq 0 ]
then
  echo "CQL script file name must be passed as an argument"
  echo "try again with a valid argument"
fi

echo "executing CQL script $1"

../../../../vos_backend/apache-cassandra-2.1.2/bin/cqlsh -f $1
