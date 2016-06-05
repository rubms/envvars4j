package org.rubms.envvars4j;

import org.rubms.envvars4j.optionhandlers.OptionHandlersRegistry;
import org.rubms.envvars4j.optionhandlers.UnnaccessibleFieldException;
import org.rubms.envvars4j.optionhandlers.UnsupportedTypeException;

import java.lang.reflect.Field;

/**
 * Class capable of populating the fields in an object instance reading the values from variables, according
 * to the provided variable provider (by default, environment variables).
 *
 * @author Rubén Martínez, @date 6/5/16 12:43 PM
 */
public class VariablePopulator {
    private Object objectToPopulate;
    private OptionHandlersRegistry optionHandlersRegistry;
    private VariableProvider variableProvider;

    /**
     * Create a new instance of VariablePopulator reading the variable values from the environment variables and
     * providing, as a parameter, an instance of the configuration object to populate.
     * @param objectToPopulate The configuration object to be populated
     *                         with the information read from environment
     *                         variables.
     */
    public VariablePopulator(Object objectToPopulate) {
        this(objectToPopulate, new EnvironmentVariableProvider());
    }

    /**
     * Create a new instance of VariablePopulator providing, as a parameter, an instance of the configuration
     * object to populate.
     * @param objectToPopulate The configuration object to be populated  with the information read from environment
     *                         variables.
     * @param variableProvider The variable provider from which to read variables.
     */
    public VariablePopulator(Object objectToPopulate, VariableProvider variableProvider) {
        this.objectToPopulate = objectToPopulate;
        this.variableProvider = variableProvider;
        this.optionHandlersRegistry = new OptionHandlersRegistry();
    }

    /**
     * Parse the provided object and populate it from variables from the chosen variable provider (by default, the
     * environment variables).
     * @throws UnsupportedTypeException
     */
    public void populateFromVariables() throws UnsupportedTypeException, UnnaccessibleFieldException {
        Field[] fields = objectToPopulate.getClass().getDeclaredFields();
        for(Field field : fields) {
            VariableOption environmentOption = field.getAnnotation(VariableOption.class);
            if (environmentOption != null) {
                String envVarStringValue = this.variableProvider.get(environmentOption.name());

                Class fieldType = field.getType();
                this.optionHandlersRegistry.getHandler(fieldType).handleOption(field, this.objectToPopulate, envVarStringValue);
            }
        }
    }
}
