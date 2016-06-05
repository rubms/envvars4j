package org.rubms.envvars4j.optionhandlers;

import java.lang.reflect.Field;

/**
 * Created by ruben on 5/06/16.
 */
public class UnnaccessibleFieldException extends Exception {
    public UnnaccessibleFieldException(Field field) {
        super("It is not possible to access the " + field.getName() + " field, nor the corresponding setter method.");
    }
}
