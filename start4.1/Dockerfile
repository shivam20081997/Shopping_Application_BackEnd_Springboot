FROM openjdk:11-jre-slim
WORKDIR usr/src
ENV MONGO_URI=mongodb://localhost:27017/mydb
ADD ./target/start4.1-0.0.1-SNAPSHOT.jar /usr/src/start4.1-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","start4.1-0.0.1-SNAPSHOT.jar"]