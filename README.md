# Spring Microservices

#### Spring을 통한 MSA 구조를 설계하고 구현한다. 

### 개발환경
* JDK 17
* Spring Boot 2.7.5
* Maven
* PostgreSQL
* Docker
* OpenFeign
* Zipkin

### 실행

### 이력
* 23.03.01 - 최초 커밋 / DB 설정 / customer, fraud 모듈 추가
* 23.03.02 - eureka server, open feign
* 23.03.04 - notification 추가
* 23.03.05 - Zipkin, ApiGateway 연동

### 참고
* [Ngnix - Load Balance](https://docs.nginx.com/nginx/admin-guide/load-balancer/http-load-balancer)
* spring-cloud-gateway (M1 사용 시) netty-resolver-dns-native-macos 설정 추가필요[참고사이트](https://github.com/netty/netty/issues/11020)