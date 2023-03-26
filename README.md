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
* RabbitMQ

### 빌드/실행
    mvn clean package -P build-docker-image
    docker compose pull
    docker-compose up -d
    docker logs [컨테이너명]

    k8s
     postgresql 접속: kubectl exec -it postgres-0 -- psql -U deneb
     터널링 활성화: kubectl tunnel
     스케일 조정: kubectl scale --replicas=0 deployment [deployment-name]

### 이력
* 23.03.01 - 최초 커밋 / DB 설정 / customer, fraud 모듈 추가
* 23.03.02 - eureka server, open feign
* 23.03.04 - notification 추가
* 23.03.05 - Zipkin, ApiGateway 연동
* 23.03.08 - RabbitMQ, Customer 도메인 연동, Consumer 추가
* 23.03.09 - Jar 패키징 구성, Docker 이미지 생성
* 23.03.10 - 모듈 별 docker 이미지 생성
* 23.03.12 - docker deploy 브렌치 생성
* 23.03.19 - k8s 기반 postgres / rabbitmq / zipkin 구축 
* 23.03.26 - customer k8s POD생성 및 배포 추가

### 참고
* [Ngnix - Load Balance](https://docs.nginx.com/nginx/admin-guide/load-balancer/http-load-balancer)
* spring-cloud-gateway (M1 사용 시) netty-resolver-dns-native-macos 설정 필요 [참고사이트](https://github.com/netty/netty/issues/11020)
* [spring-boot-maven-plugin](https://docs.spring.io/spring-boot/docs/current/maven-plugin/reference/htmlsingle/)