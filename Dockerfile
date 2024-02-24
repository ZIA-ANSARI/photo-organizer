# Use a base image with the desired JDK and other dependencies
FROM openjdk:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/photo-organizer-0.0.1-SNAPSHOT.jar /app

# Expose the port your application listens on
EXPOSE 8080

# Command to run your application
CMD ["java", "-jar", "photo-organizer-0.0.1-SNAPSHOT.jar"]
