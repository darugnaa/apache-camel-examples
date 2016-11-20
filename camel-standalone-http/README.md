Camel Standalone :: HTTP
=========================

This example demonstrates how to build routes using Java DSL, retrieve
web pages using [HTTP component](https://camel.apache.org/http.html),
extract data using JSoup library.

# Application format
This application is a Java8 console application.
- uses Java DSL to build routes
- uses standalone Camel
- can be run and debugged inside an IDE

# Instructions
Build with standard Maven commands:

    cd camel-standalone-http
    mvn clean verify
	mvn exec:java

Press `CTRL + C` to quit.
	