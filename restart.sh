#!/bin/sh
docker stop product-service
docker stop product-db
docker image rm -f productservice-product-service
rm -r ./target
mvn package -Dmaven.test.skip
docker-compose up