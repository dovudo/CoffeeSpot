FROM openjdk:11
MAINTAINER Coffee
COPY . /usr/share/coffee-backend/
WORKDIR /usr/share/coffee-backend/
#RUN bash ./gradlew clean build --stacktrace
#RUN ls -h build/libs
#COPY ./build/libs/* ./
ENTRYPOINT java -jar ./backend.jar
