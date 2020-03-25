FROM openjdk:11
MAINTAINER Coffee
COPY . /usr/share/coffee-backend/
WORKDIR /usr/share/coffee-backend/
RUN ./gradlew build --stacktrace
RUN ls -h build/libs
ENTRYPOINT java -jar build/libs/backend.jar
