FROM openjdk:8
ADD target/petMicroService-0.0.1-SNAPSHOT.jar petMicroService-0.0.1-SNAPSHOT.jar
EXPOSE 8090
ENTRYPOINT java -jar -Dspring.profiles.active=prod petMicroService-0.0.1-SNAPSHOT.jar