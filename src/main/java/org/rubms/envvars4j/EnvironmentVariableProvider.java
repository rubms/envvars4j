package org.rubms.envvars4j;

/**
 * The default implementation of variable provider, that reads
 * environment variables.
 * @author Rubén Martínez Sobrino
 */
public class EnvironmentVariableProvider implements VariableProvider {
    @Override
    public String get(String name) {
        return System.getenv(name);
    }
}
