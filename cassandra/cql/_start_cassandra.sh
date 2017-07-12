#!/bin/bash

# used to start cassandra service

# To stop the service:
# 1- ps auwx | grep cassandra
# 2- kill -9 PID

../../../vos_backend/apache-cassandra-2.1.2/bin/cassandra &> /dev/null
