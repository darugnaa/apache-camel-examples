# Camel Example :: Spring :: MQTT
This example sets up two Camel routes, one for publishing messages and one
for receiving messages over MQTT.

# Application format
This application is a Java8 console application.
- uses Spring for configuration
- all required libraries are included ("shaded") into final jar (aka _uber
jar_) using maven-shade-plugin
- can be run and debugged inside an IDE

# Instructions
Standard Maven commands:
    cd camel-spring-mqtt
    mvn clean verify
    java -jar target\camel-spring-mqtt-1.0.0.jar
    
Press `CTRL + C` to quit.
