FROM openjdk:8-jre-alpine
VOLUME /data
WORKDIR /app
ENV DEFAULT_JVM_OPTS "-Xms256M -Xmx512M"
ENV JAVA_OPTS "-Dserver.port=8080"
ENV TIME_ZONE "Asia/Shanghai"
RUN ln -snf /usr/share/zoneinfo/$TIME_ZONE /etc/localtime && echo $TIME_ZONE > /etc/timezone
ADD build/distributions/uid-generator-spring-boot-starter-boot-*.tar .
RUN mv uid-generator-spring-boot-starter-boot-* uid-generator
ENTRYPOINT ["uid-generator/bin/uid-generator-spring-boot-starter"]
