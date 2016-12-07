# Example on Karaf 4.0.x

Camel is not installed into Karaf by default, it must be installed.
Luckily installation is just a matter of a couple commands to type into Karaf
shell. Camel is conveniently available as a [Karaf feature](https://dzone.com/articles/apache-karaf-features-for-osgi-deployment).  
Please mind that each command explicitly mention the desidered version!
By default the version used is `LATEST`, which may not be what you expect.

Type the following commands into Karaf shell:

    feature:repo-add mvn:org.apache.camel.karaf/apache-camel/2.18.1/xml/features
    feature:install camel/2.18.1

Camel is now installed! Check the installation with `list` command.

> list
> karaf@root()> list
> START LEVEL 100 , List Threshold: 50
> ID | State  | Lvl | Version | Name
> --------------------------------------------------
> 52 | Active |  50 | 2.18.1  | camel-blueprint
> 53 | Active |  50 | 2.18.1  | camel-catalog
> 54 | Active |  50 | 2.18.1  | camel-commands-core
> 55 | Active |  50 | 2.18.1  | camel-core
> 56 | Active |  80 | 2.18.1  | camel-karaf-commands

> feature:list | grep camel-2.18

camel: commands will be added

Project generated with camel-archetype-blueprint

Windows command line:
    mvn archetype:generate ^
      -DarchetypeGroupId=org.apache.camel.archetypes ^
      -DarchetypeArtifactId=camel-archetype-blueprint ^
      -DarchetypeVersion=2.18.1 ^
      -DgroupId=org.darugna.camel ^
      -DartifactId=camel-blueprint-karaf ^
      -Dversion=1.0.0

