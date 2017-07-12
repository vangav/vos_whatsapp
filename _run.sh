#!/bin/bash

# used to run the service in dev mode on port 9000 or arg port
#   with live compiling on code change/save
#   for production, use dist.sh

port=9000

if [ "$1" -ne 0 ]
then
  port="$1"
fi

echo "using port $port"

../vos_backend/play-2.2.6/play "run $port"
