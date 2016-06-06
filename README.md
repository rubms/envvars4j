# envvars4j
Environment variable parsing for Java.

## Why envvars4j
Given the growing use of containers, like Docker, it is becoming more and more common to configure applications via environment variables because:

* The container technology allows to isolate the environment variables scope to the application itself.
* It is a very convenient way for the people in charge of deploying your application to configure it in a container orchestrator.

There are several Java libraries in charge of parsing arguments from the command line and populating a configuration object with the result of the parsing. However it seems like there are no libraries providing that same features for some source of named variable values (more concretely, environment variables).

That is what envvars4j tries to cover: automatic object population from a source of named variable values (already including a provider that uses the environment variables as source, which is the default behaviour).

## How to use envvars4j
You have to include the library dependency to your project.

In order to do that, first include `https://dl.bintray.com/rubms/maven/` in your repository list:

From gradle
```groovy
repositories { 
    maven { 
        url "http://dl.bintray.com/rubms/maven" 
    } 
}
```

From maven
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<settings xsi:schemaLocation='http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd'
    xmlns='http://maven.apache.org/SETTINGS/1.0.0'
    xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>
    <profiles>
        <profile>
            <repositories>
                <repository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>bintray-rubms-maven</id>
                    <name>bintray</name>
                    <url>http://dl.bintray.com/rubms/maven</url>
                </repository>
            </repositories>
            <pluginRepositories>
                <pluginRepository>
                    <snapshots>
                        <enabled>false</enabled>
                    </snapshots>
                    <id>bintray-rubms-maven</id>
                    <name>bintray-plugins</name>
                    <url>http://dl.bintray.com/rubms/maven</url>
                </pluginRepository>
            </pluginRepositories>
            <id>bintray</id>
        </profile>
    </profiles>
    <activeProfiles>
        <activeProfile>bintray</activeProfile>
    </activeProfiles>
</settings>
```

Then include the dependency in your project:

From gradle
```groovy
dependencies {
   compile 'org.rubms:envvars4j:1.0.0'
}
```

From maven
```xml
<dependency>
  <groupId>org.rubms</groupId>
  <artifactId>envvars4j</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```

If you dont use an automated build solution like gradle or maven you can always download the jar from https://dl.bintray.com/rubms/maven/ and include it in your project.

Once you have the dependency included in your project, using envvars4j is very simple.

In the POJO in which you are going to place the configuration, annotate the fields to populate with `@VariableOption`, as shown in the following example:
```java
public class Person {
    @VariableOption(name="GIVEN_NAME")
    private String givenName = "Alan Turing"; // The default value is Alan Turing

    @VariableOption(name="AGE")
    private int age = 41; // The default value is 41

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

In order to populate this POJO with the contents read from environment variables:
```java
Person person = new Person();

VariablePopulator variablePopulator = new VariablePopulator(person);
variablePopulator.populateFromVariables();
```

In case you have implemented your own version of VariableProvider (instead of relying on the default environment variables behavior) you can specify your variable provider in the constructor of the VariablePopulator:
```java
Person person = new Person();

VariablePopulator variablePopulator = new VariablePopulator(person, yourVariableProvider);
variablePopulator.populateFromVariables();
```