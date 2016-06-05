package org.rubms.envvars4j.optionhandlers;

import static org.junit.Assert.assertEquals;

/**
 * Created by ruben on 5/06/16.
 */
public class FloatObjectOptionHandlerTest {
    Float testFloatObject;

    @org.junit.Test
    public void handleFloatObjectOption() throws Exception {
        this.testFloatObject = new Float(0);
        FloatObjectOptionHandler FloatObjectOptionHandler = new FloatObjectOptionHandler();
        FloatObjectOptionHandler.handleOption(this.getClass().getDeclaredField("testFloatObject"), this, "23.65");
        assertEquals(23.65, this.testFloatObject.floatValue(), 0.001);
    }
}