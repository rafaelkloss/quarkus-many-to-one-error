FROM maven:3.5.4-jdk-8-alpine AS MAVEN_TOOL

#COPY settings.xml /root/.m2/
COPY src /tmp/src
COPY .mvn /tmp/.mvn
COPY pom.xml /tmp/
COPY mvnw /tmp/

WORKDIR /tmp/

# https://issues.jenkins-ci.org/browse/JENKINS-47890
# mvnw bugadão: workaround:
#RUN unset MAVEN_CONFIG && chmod +x mvnw && ./mvnw compile quarkus:build -Dnative -Dquarkus.profile=prod
ARG version
RUN mvn compile quarkus:build -Dnative -Dquarkus.profile=${version}

# Second stage
FROM openjdk:8
RUN mkdir /var/log/api/
ENV JAVA_OPTS="-Djava.net.preferIPv4Stack=true -Djava.net.preferIPv4Addresses=true"
RUN ln -sf /usr/share/zoneinfo/America/Sao_Paulo /etc/localtime
EXPOSE 8080
COPY --from=MAVEN_TOOL /tmp/target /app
WORKDIR /app/
ENTRYPOINT exec java $JAVA_OPTS -jar $(ls *.jar)
