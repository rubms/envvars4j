package org.rubms.envvars4j.optionhandlers;

/**
 * Created by ruben on 5/06/16.
 */
public class UnsupportedTypeException extends Exception {
    public UnsupportedTypeException(Class c) {
        super("It is not possible to parse fields of type " + c.getName());
    }
}
