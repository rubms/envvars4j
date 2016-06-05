package org.rubms.envvars4j;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by ruben on 5/06/16.
 */
@Retention(RUNTIME)
@Target({FIELD,METHOD,PARAMETER})
public @interface VariableOption {
    /**
     * Name of the option, such as <code>FOO_ENVIRONMENT_OPTION</code>.
     */
    String name();
}
