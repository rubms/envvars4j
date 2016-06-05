package org.rubms.envvars4j;

/**
 * Interface implemented by variable value providers. The default
 * implementation is the reading of environment variables. However
 * other implementations could be provided to read, for example,
 * from Java Sytem properties.
 * @author Rubén Martínez Sobrino
 */
public interface VariableProvider {
    /**
     * Get the value of the variable identified by the given variable name.
     * @param name The name of the variable to be retrieved.
     * @return The value of the read variable. Null in case the variable
     * cannot be found.
     */
    String get(String name);
}
