FROM openjdk:11-jre-slim

LABEL maintainer="devops@petz.com.br"

WORKDIR /app

COPY target/demo.jar . 

EXPOSE 8080

CMD ["java", "-jar", "demo.jar"]