FROM adoptopenjdk/openjdk11:jdk-11.0.2.9-slim
WORKDIR /opt
ENV PORT 8085
EXPOSE 8085
COPY target/*.jar /opt/eureka.jar
ENTRYPOINT exec java $JAVA_OPTS -jar eureka.jar