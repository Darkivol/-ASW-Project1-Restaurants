# Dockerfile for the cities application
FROM frolvlad/alpine-oraclejdk8

# Install the application binary
ADD build/libs/cities-0.0.1-SNAPSHOT.jar cities.jar

# Launch the Java application
ENTRYPOINT ["/usr/bin/java", "-Xmx128m", "-Xms128m"]
CMD ["-jar", "cities.jar"]