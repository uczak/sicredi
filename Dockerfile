FROM eclipse-temurin:17-jdk-alpine as builder
COPY . /app
WORKDIR /app
RUN ./gradlew build

FROM eclipse-temurin:17-jre-alpine
WORKDIR /opt/app-root/src
COPY --from=builder /app/build/libs/sicredi.jar /opt/app-root/src/app.jar
CMD java $JAVA_OPTS -jar app.jar

