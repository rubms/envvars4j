package org.rubms.envvars4j.optionhandlers;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by ruben on 5/06/16.
 */
public abstract class AbstractOptionHandler {
    public void handleOption(Field field, Object containingObject, String environmentOption)
            throws UnnaccessibleFieldException{
        try {
            field.set(containingObject, parseFieldValue(environmentOption));
        } catch(IllegalAccessException ex) {
            try {
                Method setterMethod = containingObject.getClass().getMethod(getSetterMethodName(field),
                        field.getType());
                setterMethod.invoke(containingObject, parseFieldValue(environmentOption));
            } catch (NoSuchMethodException noSuchMethodException) {
                throw new UnnaccessibleFieldException(field);
            } catch (IllegalAccessException illegalAccessException) {
                throw new UnnaccessibleFieldException(field);
            } catch (InvocationTargetException invocationTargetException) {
                throw new UnnaccessibleFieldException(field);
            }
        }
    }

    protected static String getSetterMethodName(Field field) {
        String fieldName = field.getName();
        return "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }

    protected abstract Object parseFieldValue(String environmentOption);
}
