
> **why?** whatsapp is a [vangav backend](https://github.com/vangav/vos_backend) template covering; service oriented architecture, worker service, multi-entry-point api, basic authentication and multi-keysapce database

# whatsapp

+ [whatsapp](https://github.com/vangav/vos_whatsapp), [whatsapp worker](https://github.com/vangav/vos_whatsapp_worker) and [whatsapp analytics](https://github.com/vangav/vos_whatsapp_analytics) services work together and are generated using [vangav backend](https://github.com/vangav/vos_backend)

## prerequisite

+ [vangav backend tutorials](https://github.com/vangav/vos_backend)

## functionality

### [whatsapp](https://github.com/vangav/vos_whatsapp)

+ handles user signup and authentication
+ sending messages
+ fetching messages and users' info
+ dispatching analytics writing to [whatsapp worker](https://github.com/vangav/vos_whatsapp_worker)

### [whatsapp worker](https://github.com/vangav/vos_whatsapp_worker)

+ handles writing analytics into the database

### [whatsapp analytics](https://github.com/vangav/vos_whatsapp_analytics)

+ handles fetching users' and messages' analytics

## overview

+ this service is based on vangav backend's [whatsapp template](https://github.com/vangav/vos_backend/tree/master/vangav_backend_templates/whatsapp)
+ this service has the 90+% of the vangav backend's generated code + the 10-% of the logic code needed to complete the service

## try this service

1. *for first timers* - follow the steps in the [system requirements tutorial](https://github.com/vangav/vos_backend#system-requirements)
2. *for first timers* - follow the steps in the [workspace initialization tutorial](https://github.com/vangav/vos_backend#init)
3. download [`vos_whatsapp.zip`](https://github.com/vangav/vos_whatsapp), [`vos_whatsapp_worker.zip`](https://github.com/vangav/vos_whatsapp_worker) and [`vos_whatsapp_analytics.zip`](https://github.com/vangav/vos_whatsapp_analytics) projects (from the green `clone or download` button) inside the workspace directory created previously (`my_services`) and unzip them
4. **rename** unzipped directories, remove the `-master` from their names
5. in the terminal `cd` to `vos_whatsapp/cassandra/cql/`
6. execute `./_start_cassandra.sh` to start cassandra
7. `cd` to `vos_whatsapp/cassandra/cql/drop_and_create/`
8. execute the commands `./_execute_cql.sh wa_....cql` to initialize the services' database tables; repeat this step for all the [`.cql` files](https://github.com/vangav/vos_whatsapp/tree/master/cassandra/cql/drop_and_create)
9. `cd` to `vos_whatsapp_worker` and execute `./_run.sh` to start the whatsapp worker service on port 8000
10. `cd` to `vos_whatsapp_analytics` and execute `./_run.sh 7000` to start the whatsapp worker service on port 7000
11. `cd` to `vos_whatsapp` and execute `./_run.sh` to start the whatsapp worker service on port 9000
12. from your prefered client (*we recommned* [postman](https://www.getpostman.com/docs/postman/launching_postman/installation_and_updates)) start trying the service; refer to the [features](https://github.com/vangav/vos_geo_server#features) and [api](https://github.com/vangav/vos_geo_server#api) sections for reference
+ at the end to stop the service: press `control + d` in the terminal session where the service was started in (10)
+ to stop cassandra: execute `ps auwx | grep cassandra` to get cassandra's `(pid)` then `kill -9 (pid)` to stop cassandra




















