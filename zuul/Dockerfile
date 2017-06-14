# Dockerfile for the zuul application
FROM frolvlad/alpine-oraclejdk8

# Install the application binary
ADD build/libs/zuul-0.0.1-SNAPSHOT.jar zuul.jar
EXPOSE 8080

# Launch the Java application
ENTRYPOINT ["/usr/bin/java", "-Xmx128m", "-Xms128m"]
CMD ["-jar", "zuul.jar"]