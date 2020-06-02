FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
WORKDIR /opt
ENV PORT 8090
EXPOSE 8090
COPY target/*.jar /opt/service1.jar
ENTRYPOINT exec java $JAVA_OPTS -jar service1.jar