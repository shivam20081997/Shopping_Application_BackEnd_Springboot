FROM openjdk:11-jre-slim
WORKDIR usr/src
EXPOSE 8085
ADD ./target/JWTSprint-0.0.1-SNAPSHOT.jar /usr/src/JWTSprint-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","JWTSprint-0.0.1-SNAPSHOT.jar"]