# Read Me First
Very Simple kafka producer/listener application with rest interface

## How to start

* Run startup.sh script or docker-compose up -d
* Create topic with command  (also present in startup.sh)
`docker exec broker \
  kafka-topics --bootstrap-server broker:9092 \
  --create \
  --topic users-topic`
* Execute query  
``curl -X POST -d '{"name": "John Doe"}' -H 'Content-Type: application/json' localhost:8080/users``