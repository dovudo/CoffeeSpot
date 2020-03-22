FROM openjdk:15-alpine
EXPOSE 8080
MAINTAINER Coffee
COPY . /usr/share/coffee-backend/
WORKDIR /usr/share/coffee-backend/
COPY ./build/libs/* ./
RUN java -version
RUN ls -h
ENTRYPOINT java -jar backend.jar

