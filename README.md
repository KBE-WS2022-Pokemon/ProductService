# product-service

Simple API prototype 

# Setup

for MAC:



    
    docker stop product-service
    docker rm product-service

    docker network create backend
    
    mvn clean package -DskipTests
    docker build -t product-service .
    
    docker run -p 5432:5432 -d --name product-service-db --network backend -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=db-product-service postgres:13-alpine
    
    docker container run --name product-service -p 8080:8084 -d --network backend product-service

