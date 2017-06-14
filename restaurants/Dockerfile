# Dockerfile for the restaurants application
FROM frolvlad/alpine-oraclejdk8

# Install the application binary
ADD build/libs/restaurants-0.0.1-SNAPSHOT.jar restaurants.jar

# Launch the Java application
ENTRYPOINT ["/usr/bin/java", "-Xmx128m", "-Xms128m"]
CMD ["-jar", "restaurants.jar"]