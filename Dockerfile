FROM openjdk:8-jdk-alpine
RUN apk add --no-cache procps

VOLUME /tmp
ENV JAVA_OPTS=""
ENV SPRING_PROFILE="Step6"
COPY ./. /
RUN ./mvnw -DskipTests package
ADD target/*.jar app.jar

ENTRYPOINT exec java $JAVA_OPTS \
 -Djava.security.egd=file:/dev/./urandom \
 -Dspring.profiles.active=$SPRING_PROFILE \
 -jar app.jar
