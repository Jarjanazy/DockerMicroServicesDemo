FROM openjdk:8
ADD target/ownerMicroService-0.0.1-SNAPSHOT.jar ownerMicroService-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT java -jar -Dspring.profiles.active=prod ownerMicroService-0.0.1-SNAPSHOT.jar