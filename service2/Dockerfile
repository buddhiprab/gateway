FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
WORKDIR /opt
ENV PORT 8091
EXPOSE 8091
COPY target/*.jar /opt/service2.jar
ENTRYPOINT exec java $JAVA_OPTS -jar service2.jar