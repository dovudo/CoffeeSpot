FROM oracle/graalvm-ce
COPY . /usr/share/coffee-backend/
ENTRYPOINT /usr/share/coffee-backend/
RUN ./gradlew build
CMD java -jar build/libs/*.jar