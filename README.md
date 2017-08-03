
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



















