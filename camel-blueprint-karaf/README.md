Karaf 4.0.7

> feature:repo-add mvn:org.apache.camel.karaf/apache-camel/2.18.0/xml/features

> feature:install camel/2.18.0

> feature:list | grep camel-2.18.0
camel: commands will be added

Project generated with camel-archetype-blueprint

Windows command line:
    mvn archetype:generate ^
      -DarchetypeGroupId=org.apache.camel.archetypes ^
      -DarchetypeArtifactId=camel-archetype-blueprint ^
      -DarchetypeVersion=2.18.0 ^
      -DgroupId=org.darugna.camel ^
      -DartifactId=camel-blueprint-karaf ^
      -Dversion=1.0.0

