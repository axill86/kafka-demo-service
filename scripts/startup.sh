#!/bin/bash
#Start the cluster up
docker-compose up -d

#Create test topic
docker exec broker \
kafka-topics --bootstrap-server broker:9092 \
             --create \
             --topic users-topic