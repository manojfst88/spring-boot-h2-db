FROM adoptopenjdk/openjdk11:jre-11.0.9.1_1-alpine
WORKDIR /home
COPY /target/spring-boot-h2-products.jar spring-boot-h2-products.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "spring-boot-h2-products.jar"]