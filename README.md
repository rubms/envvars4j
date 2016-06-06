# envvars4j
Environment variable parsing for Java.

## Why envvars4j
Given the growing use of containers, like Docker, it is becoming more and more common to configure applications via environment variables because:

* The container technology allows to isolate the environment variables scope to the application itself.
* It is a very convenient way for the people in charge of deploying your application to configure it in a container orchestrator.

There are several Java libraries in charge of parsing arguments from the command line and populating a configuration object with the result of the parsing. However it seems like there are no libraries providing that same features for some source of named variable values (more concretely, environment variables).

That is what envvars4j tries to cover: automatic object population from a source of named variable values (already including a provider that uses the environment variables as source, which is the default behaviour).

## How to use envvars4j
You have to include the library dependency to your project:

* From gradle: `TO-DO: pending concession of binary repository for the project`
* From maven: `TO-DO: pending concession of binary repository for the project`

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