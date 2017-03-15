# Camel Route As A Service

This example shows how to export a Camel Route using an interface and OSGi services.
The interface has two different methods with different signatures,
and includes proper annotation to instruct Camel on how to do parameter binding.

Bundle `raas-service-provider` exports the service, while `raas-service-consumer` uses it.
Consumer bundle will invoke the service interface through Java and through Camel using `bean:` component.

OSGi service import and export is done using Blueprint.

## Install Camel in Karaf
This example runs in Karaf 4.0.x and requires Camel to be installed.  
Type the following commands into Karaf shell:

    feature:repo-add mvn:org.apache.camel.karaf/apache-camel/2.18.1/xml/features
    feature:install camel/2.18.1

## Build
    
    cd camel-blueprint-route-as-a-service
    mvn install

## Install service provider
Inside Karaf:

    karaf@root()> bundle:install mvn:org.darugna.camel/raas-service-provider/1.0.0
    Bundle ID: 61
    
    karaf@root()> start 61
    
Bundle is now started, and it published its service to the OSGi registry. Check with the following command:
    
    karaf@root()> bundle:services 61

    Camel Blueprint :: RAAS :: Service provider (61) provides:
    ----------------------------------------------------------
    [org.osgi.service.blueprint.container.BlueprintListener]
    [org.apache.camel.CamelContext]
    [org.darugna.camel.raas.CamelRaas]
    [org.osgi.service.blueprint.container.BlueprintContainer]
    
## Install service consumer
    
    karaf@root()> bundle:install mvn:org.darugna.camel/raas-service-consumer/1.0.0
    Bundle ID: 62
    
    karaf@root()> start 62
    
    karaf@root()> log:tail