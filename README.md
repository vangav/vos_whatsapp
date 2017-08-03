
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
12. from your prefered client (*we recommned* [postman](https://www.getpostman.com/docs/postman/launching_postman/installation_and_updates)) start trying the service; refer to the **features** and **service references** sections for reference
+ at the end to stop the services: press `control + d` in the terminal session where each service was started in (9, 10 and 11)
+ to stop cassandra: execute `ps auwx | grep cassandra` to get cassandra's `(pid)` then `kill -9 (pid)` to stop cassandra

## covered topics

+ generate multiple services (main + worker + analytics) to work together in a service oriented architecture
+ generate a multi-keyspace database
+ basic authentication

## features

### [whatsapp](https://github.com/vangav/vos_whatsapp)

| controller(s) | feature |
| ------------- | ------- |
| [signup](https://github.com/vangav/vos_whatsapp/tree/master/app/com/vangav/vos_whatsapp/controllers/signup) | handles new users' signup using phone numbers |
| [send message](https://github.com/vangav/vos_whatsapp/tree/master/app/com/vangav/vos_whatsapp/controllers/send_message) | handles sending a message |
| [get messages](https://github.com/vangav/vos_whatsapp/tree/master/app/com/vangav/vos_whatsapp/controllers/get_messages) and [get user info](https://github.com/vangav/vos_whatsapp/tree/master/app/com/vangav/vos_whatsapp/controllers/get_user_info) | handles getting new messages and users' info (id, name, ...) |

### [whatsapp analytics](https://github.com/vangav/vos_whatsapp_analytics)

| controllers | feature |
| ------------- | ------- |
| [get users count](https://github.com/vangav/vos_whatsapp_analytics/tree/master/app/com/vangav/vos_whatsapp_analytics/controllers/get_users_count) and [get messages count](https://github.com/vangav/vos_whatsapp_analytics/tree/master/app/com/vangav/vos_whatsapp_analytics/controllers/get_messages_count) | handles fetching analytics data (total counts and count per-day) |

## service references

### [whatsapp](https://github.com/vangav/vos_whatsapp)

| reference | explanation |
| --------- | ----------- |
| [routes](https://github.com/vangav/vos_whatsapp/blob/master/conf/routes) | api routes |
| [controllers.json](https://github.com/vangav/vos_whatsapp/blob/master/generator_config/controllers.json) | api request/response's elements |
| [wa_auth.keyspace](https://github.com/vangav/vos_whatsapp/blob/master/generator_config/wa_auth.keyspace) | `wa_auth` is the keyspace used for all authentication-related tables |
| [wa_users.keyspace](https://github.com/vangav/vos_whatsapp/blob/master/generator_config/wa_users.keyspace) | `wa_users` is the keyspace used for all users-info-related tables |
| [wa_chat.keyspace](https://github.com/vangav/vos_whatsapp/blob/master/generator_config/wa_chat.keyspace) | `wa_chat` is the keyspace used for all chat-related tables |
| [wa_blobs.keyspace](https://github.com/vangav/vos_whatsapp/blob/master/generator_config/wa_blobs.keyspace) | `wa_blobs` is the keyspace used for all blobs-related tables |
| [wa_analysis.keyspace](https://github.com/vangav/vos_whatsapp/blob/master/generator_config/wa_analysis.keyspace) | `wa_analysis` is the keyspace used for all analysis-related tables |
| [common](https://github.com/vangav/vos_whatsapp/tree/master/app/com/vangav/vos_whatsapp/controllers/common) | handles controllers' common operations like authentication |
| [controllers](https://github.com/vangav/vos_whatsapp/tree/master/app/com/vangav/vos_whatsapp/controllers) | api implementation |
| [wa_auth](https://github.com/vangav/vos_whatsapp/tree/master/app/com/vangav/vos_whatsapp/cassandra_keyspaces/wa_auth) | `wa_auth` cassandra's keyspace client |
| [wa_users](https://github.com/vangav/vos_whatsapp/tree/master/app/com/vangav/vos_whatsapp/cassandra_keyspaces/wa_users) | `wa_users` cassandra's keyspace client |
| [wa_chat](https://github.com/vangav/vos_whatsapp/tree/master/app/com/vangav/vos_whatsapp/cassandra_keyspaces/wa_chat) | `wa_chat` cassandra's keyspace client |
| [wa_blobs](https://github.com/vangav/vos_whatsapp/tree/master/app/com/vangav/vos_whatsapp/cassandra_keyspaces/wa_blobs) | `wa_blobs` cassandra's keyspace client |
| [wa_analysis](https://github.com/vangav/vos_whatsapp/tree/master/app/com/vangav/vos_whatsapp/cassandra_keyspaces/wa_analysis) | `wa_analysis` cassandra's keyspace client |

### [whatsapp analytics](https://github.com/vangav/vos_whatsapp_analytics)

| reference | explanation |
| --------- | ----------- |
| [routes](https://github.com/vangav/vos_whatsapp_analytics/blob/master/conf/routes) | api routes |
| [controllers.json](https://github.com/vangav/vos_whatsapp_analytics/blob/master/generator_config/controllers.json) | api request/response's elements |
| [wa_analysis.keyspace](https://github.com/vangav/vos_whatsapp_analytics/blob/master/generator_config/wa_analysis.keyspace) | `wa_analysis` is the keyspace used for all analysis-related tables |
| [controllers](https://github.com/vangav/vos_whatsapp_analytics/tree/master/app/com/vangav/vos_whatsapp_analytics/controllers) | api implementation |
| [wa_analysis](https://github.com/vangav/vos_whatsapp_analytics/tree/master/app/com/vangav/vos_whatsapp_analytics/cassandra_keyspaces/wa_analysis) | `wa_analysis` cassandra's keyspace client |

## change log

+ this section lists the 10-% code added after vangav backend generated 90+% of the code

### [whatsapp](https://github.com/vangav/vos_whatsapp)

| file/dir | change |
| -------- | ------ |
| [common](https://github.com/vangav/vos_whatsapp/tree/master/app/com/vangav/vos_whatsapp/controllers/common) | added common controllers' operations like authentication |
| [controllers](https://github.com/vangav/vos_whatsapp/tree/master/app/com/vangav/vos_whatsapp/controllers) | added the implementation of request processing logic under `controller_name/HandlerControllerName.java` classes and nested response json structures under `controller_name/response_json` packages |

### [whatsapp analytics](https://github.com/vangav/vos_whatsapp_analytics)

| file/dir | change |
| -------- | ------ |
| [controllers](https://github.com/vangav/vos_whatsapp_analytics/tree/master/app/com/vangav/vos_whatsapp_analytics/controllers) | added the implementation of request processing logic under `controller_name/HandlerControllerName.java` classes and nested response json structures under `controller_name/response_json` packages |

## error codes

+ following are the error codes of whatsapp services

### [whatsapp](https://github.com/vangav/vos_whatsapp)

| class | code : sub_code | explanation |
| ----- | --------------- | ----------- |
| [CommonPlayHandler](https://github.com/vangav/vos_whatsapp/blob/master/app/com/vangav/vos_whatsapp/controllers/CommonPlayHandler.java) |  |  |
|  | 300 : 1 | user not signed up |
|  | 300 : 2 | wrong password |
| [HandlerSignup](https://github.com/vangav/vos_whatsapp/blob/master/app/com/vangav/vos_whatsapp/controllers/signup/HandlerSignup.java) |  |  |
|  | 301 : 1 | user has no password |
|  | 301 : 2 | wrong password |
| [HandlerGetUserInfo](https://github.com/vangav/vos_whatsapp/blob/master/app/com/vangav/vos_whatsapp/controllers/get_user_info/HandlerGetUserInfo.java) |  |  |
|  | 302 : 1 | user not registered |
|  | 302 : 2 | didn't find user's info |
| [HandlerSendMessage](https://github.com/vangav/vos_whatsapp/blob/master/app/com/vangav/vos_whatsapp/controllers/send_message/HandlerSendMessage.java) |  |  |
|  | 303 : 1 | can't send message(s) to yourself |
|  | 303 : 2 | message's recieving user isn't registered |
| [HandlerGetMessages](https://github.com/vangav/vos_whatsapp/blob/master/app/com/vangav/vos_whatsapp/controllers/get_messages/HandlerGetMessages.java) |  |  |
|  | 304 : 1 | didn't find message's blob (content) |

### [whatsapp analytics](https://github.com/vangav/vos_whatsapp_analytics)

| class | code : sub_code | explanation |
| ----- | --------------- | ----------- |
| []() |  |  |
| []() |  |  |
| []() |  |  |
| []() |  |  |
| []() |  |  |
| []() |  |  |
| []() |  |  |
| []() |  |  |
| []() |  |  |
| []() |  |  |
| []() |  |  |
| []() |  |  |

















