# Dockerfile for the ratings application
FROM frolvlad/alpine-oraclejdk8

# Install the application binary
ADD build/libs/ratings-0.0.1-SNAPSHOT.jar ratings.jar

# Launch the Java application
ENTRYPOINT ["/usr/bin/java", "-Xmx128m", "-Xms128m"]
CMD ["-jar", "ratings.jar"]