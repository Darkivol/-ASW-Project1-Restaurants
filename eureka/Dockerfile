# Dockerfile for the eureka application
FROM frolvlad/alpine-oraclejdk8

# Install the application binary
ADD build/libs/eureka-0.0.1-SNAPSHOT.jar eureka.jar
EXPOSE 8010

# Launch the Java application
ENTRYPOINT ["/usr/bin/java", "-Xmx128m", "-Xms128m"]
CMD ["-jar", "eureka.jar"]