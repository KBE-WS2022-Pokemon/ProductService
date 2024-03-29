# product-service

Simple API prototype 

# Setup

- Make sure no old images exist
- Make sure RabbitMQ is running with the docker-compose from "Main" repository
- Delete old .jar files in ./target if they exist

```shell
    mvn package
    docker-compose up -d
```

```shell
    docker stop product-service
    docker rm product-service
    docker image rm productservice-product-service@latest
    rm -r ./target
    mvn package
    docker-compose up -d
```

# Old Setup

    docker network create backend
    mvn clean package -DskipTests
    docker-compose up -d


for MAC:
    
    docker stop product-service
    docker rm product-service

    docker network create backend
    
    mvn clean package -DskipTests
    docker build -t product-service .
    
    docker run -p 5432:5432 -d --name product-db --network backend -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=product-db postgres:13-alpine
    
    docker container run --name product-service -p 8084:8084 -d --network backend product-service


docker stop product-service
docker rm product-service
mvn clean package -DskipTests
docker build -t product-service .
docker container run --name product-service -p 8084:8084 -d --network backend product-service

