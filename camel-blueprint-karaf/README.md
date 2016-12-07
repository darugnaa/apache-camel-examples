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

    karaf@root()> list
    START LEVEL 100 , List Threshold: 50
    ID | State  | Lvl | Version | Name
    --------------------------------------------------
    52 | Active |  50 | 2.18.1  | camel-blueprint
    53 | Active |  50 | 2.18.1  | camel-catalog
    54 | Active |  50 | 2.18.1  | camel-commands-core
    55 | Active |  50 | 2.18.1  | camel-core
    56 | Active |  80 | 2.18.1  | camel-karaf-commands

Only basic camel-core is installed, together with `camel:` shell commands.
To see other available [components](http://camel.apache.org/components.html) type the following command:

    feature:list | grep camel-2.18

Installation is easy as before: `feature:install camel-whatyouwant/2.18.1`

## Blueprint bundle
This maven project has been generated from `camel-archetype-blueprint` archetype.

Windows command line:

    mvn archetype:generate ^
      -DarchetypeGroupId=org.apache.camel.archetypes ^
      -DarchetypeArtifactId=camel-archetype-blueprint ^
      -DarchetypeVersion=2.18.1 ^
      -DgroupId=org.darugna.camel ^
      -DartifactId=camel-blueprint-karaf ^
      -Dversion=1.0.0

This project is Blueprint bundle. After building it with the classic `mvn install`, deploy inside Karaf by entering this command in Karaf shell:

    install -s mvn:org.darugna.camel/camel-blueprint-karaf/1.0.0
	
Karaf should answer by stating the bundle ID:

    Bundle ID: 60
	
This on my machine, on yours the bundle ID may be different.  
The bundle is logging something, use `log:tail` to see the messages, press _CTRL + C_ to return to the shell.
