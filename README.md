# Warehouse

Simple API prototype 

# Setup

for MAC:



    
    docker stop warehouse
    docker rm warehouse

    docker network create backend
    
    mvn clean package -DskipTests
    docker build -t warehouse .
    
    docker run -p 5432:5432 -d --name warehouse-db --network backend -e POSTGRES_PASSWORD=123456 -e POSTGRES_DB=db-warehouse postgres:13-alpine
    
    docker container run --name warehouse -p 8080:8084 -d --network backend warehouse

