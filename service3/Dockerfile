FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
WORKDIR /opt
ENV PORT 8092
EXPOSE 8092
COPY target/*.jar /opt/service3.jar
ENTRYPOINT exec java $JAVA_OPTS -jar service3.jar