package org.rubms.envvars4j.optionhandlers;

/**
 * Created by ruben on 5/06/16.
 */
public class DoubleOptionHandler extends AbstractOptionHandler {
    @Override
    public Object parseFieldValue(String environmentOption) {
        return Double.parseDouble(environmentOption);
    }
}
