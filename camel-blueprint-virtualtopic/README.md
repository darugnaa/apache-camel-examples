# Camel Example :: Blueprint :: Virtual Topics
This example publishes and receives text messages over JMS using
[ActiveMQ](http://camel.apache.org/activemq.html) component of Apache Camel.  
It's focused on the use of [Virtual Topics](http://activemq.apache.org/virtual-destinations.html).
They combine a _publish-subscribe_ model with the advantages of queues
(load balancing of workload, persistence, single processing of a message).

Destination names used in this example leveraghe the out-of-the-box defaults
of ActiveMQ: virtual topics are named **VirtualTopic.**, consumer queues
are named **Consumer.*.VirtualTopic.>**.

## Application format
This application is a Java8 OSGi bundle.
- uses Blueprint for configuration
- all required libraries must be installed inside the container ([JBoss Fuse 6.3.0](https://developers.redhat.com/products/fuse/download/) provides everything out of the box)
- can be run and debugged inside an IDE (launch Karaf with `./karaf debug` or JBoss Fuse with `./fuse debug`)

## Instructions
Build with standard Maven commands:

    cd camel-blueprint-virtualtopic
    mvn clean verify

Install into JBoss Fuse / Apache Karaf:

    install mvn:org.darugna.camel/camel-blueprint-virtualtopic/1.0.0

