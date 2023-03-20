#!/bin/sh
docker stop product-service
docker stop product-db
docker image rm -f productservice-product-service
rm -r ./target
mvn package
docker-compose up -d