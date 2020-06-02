# API Gateway implementation using Spring Boot, Spring Cloud, Netflix Zuul, Netflix Eureka Discovery Server

### API Gateway Design

![](images/zuul_ribbon_loadbalancer.jpg)

##### Ribbon Loadbalancer retry mechanism 

![](images/zuul_ribbon_loadbalancer_retry.jpg)

#### for https support, created self signed certificates

```
keytool -genkeypair -alias gateway -keyalg RSA -keysize 2048 -keystore keystore.jks -validity 3650 -storepass password
```

#### Docker commands
```
#list docker containers
docker ps

#list docker images
docker images

#stop container by name
docker stop zuul

#delete image
docker image rm zuul
```

#### Create docker image for eureka service discovery app

```
cd eureka
mvn clean package
docker build -t eureka .
```

#### Create docker image for zuul gateway app

```
cd zuul
mvn clean package
docker build -t zuul .
```

#### Create docker image for service1 app

```
cd service1
mvn clean package
docker build -t service1 .
```

#### Create docker image for service2 app

```
cd service2
mvn clean package
docker build -t service2 .
```

#### Create docker image for service3 app

```
cd service3
mvn clean package
docker build -t service3 .
```

#### Create new Docker network named api
```
docker network create api
```

#### run apps as Docker containers

```
docker run -d --name=eureka --rm --network=api -p 8085:8085 eureka
docker run -d --name=zuul --rm --network=api -p 8080:8080 zuul
docker run -d --name=service1 --rm --network=api -p 8090:8090 service1
docker run -d --name=service2 --rm --network=api -p 8091:8091 service2
docker run -d --name=service3 --rm --network=api -p 8092:8092 service3
```

#### Test via Postman

##### To enable https in Postman, download the .cer via chrome and conver to .pem and then import certificate in Postman settings
```
openssl x509 -inform der -in localhost.cer -out certificate.pem
```

#### End points

##### JWT token endpoint
```
request: 

POST /token HTTPS
Host: localhost:8080
Content-Type: application/json

{    
    "username": "admin",
    "password": "password"
}


response:

{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6Imh0dHA6Ly9qd3RkZW1vLmNvbSIsImlhdCI6MTU5MTEyMTUzMCwiZXhwIjoxNTkxMTI4NzMwfQ.BJo3AF8ialex6KS9oPvBjV8-gj20uHSSdwX3Ra3cB_M"
}
```

##### Service 1

```
request:

GET /api/service1/test1?param1=1 HTTPS
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6Imh0dHA6Ly9qd3RkZW1vLmNvbSIsImlhdCI6MTU5MTEyMTUzMCwiZXhwIjoxNTkxMTI4NzMwfQ.BJo3AF8ialex6KS9oPvBjV8-gj20uHSSdwX3Ra3cB_M


response:

/service1/test1?param1=1

```

##### Service 2

```
request:

POST /api/service2/test2 HTTPS
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6Imh0dHA6Ly9qd3RkZW1vLmNvbSIsImlhdCI6MTU5MTEyMDI4OCwiZXhwIjoxNTkxMTI3NDg4fQ.JYOuw2xkLuZZinVpLiQDlSvhI38US-HiaA7NpZVTwGs


response:

/service2/test2

```

##### Service 3

```
request:

PATCH /api/service3/test3/misc HTTPS
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6Imh0dHA6Ly9qd3RkZW1vLmNvbSIsImlhdCI6MTU5MTEyMTUzMCwiZXhwIjoxNTkxMTI4NzMwfQ.BJo3AF8ialex6KS9oPvBjV8-gj20uHSSdwX3Ra3cB_M

response:

/service3/test3

```

##### http request

```
request:

GET /api/service1/test1?param1=1 HTTP/1.1
Host: localhost:8080
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlzcyI6Imh0dHA6Ly9qd3RkZW1vLmNvbSIsImlhdCI6MTU5MTEyMTUzMCwiZXhwIjoxNTkxMTI4NzMwfQ.BJo3AF8ialex6KS9oPvBjV8-gj20uHSSdwX3Ra3cB_M


response:

Bad Request
This combination of host and port requires TLS.

```

#### H2 database access

```
access url: https://localhost:8080/h2-console

jdbc url: jdbc:h2:mem:testdb
username: sa
password: password
```

![](images/h2-1.png)

![](images/h2-2.png)