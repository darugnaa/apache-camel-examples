# Camel Example :: Spring :: MQTT
This example publishes and receives data in JSON format using the
[MQTT](https://camel.apache.org/mqtt.html) component of Apache Camel.
There are two Camel routes, one for publishing messages and one
for receiving messages over MQTT.  
A simple POJO is marshalled using [Gson DataFormat]
(http://camel.apache.org/json.html)

**work in progress**

# Application format
This application is a Java8 console application.
- uses Spring for configuration
- all required libraries are included ("shaded") into final jar (aka _uber
jar_) using maven-shade-plugin
- can be run and debugged inside an IDE

# Instructions
Build with standard Maven commands:

    cd camel-spring-mqtt
    mvn clean verify
    java -jar target\camel-spring-mqtt-1.0.0.jar
    
Press `CTRL + C` to quit.
