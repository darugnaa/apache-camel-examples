

## Build
    
    cd camel-blueprint-route-as-a-service
    mvn install

## Install service provider
    Inside Karaf:
    karaf@root()> bundle:install mvn:org.darugna.camel/raas-service-provider/1.0.0
    Bundle ID: 61
    
    karaf@root()> start 61
    
    karaf@root()> bundle:services 61

    Camel Blueprint :: RAAS :: Service provider (61) provides:
    ----------------------------------------------------------
    [org.osgi.service.blueprint.container.BlueprintListener]
    [org.apache.camel.CamelContext]
    [org.darugna.camel.raas.CamelRaas]
    [org.osgi.service.blueprint.container.BlueprintContainer]
    
## Install service consumer
    
    karaf@root()> bundle:install mvn:org.darugna.camel/raas-service-consumer/1.0.0