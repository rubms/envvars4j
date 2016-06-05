package org.rubms.envvars4j.optionhandlers;

/**
 * Created by ruben on 5/06/16.
 */
public class IntObjectOptionHandler extends AbstractOptionHandler {
    @Override
    public Object parseFieldValue(String environmentOption) {
        return Integer.valueOf(environmentOption);
    }
}
