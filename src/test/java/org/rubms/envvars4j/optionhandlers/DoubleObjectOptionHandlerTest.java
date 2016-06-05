package org.rubms.envvars4j.optionhandlers;

import static org.junit.Assert.*;

/**
 * Created by ruben on 5/06/16.
 */
public class DoubleObjectOptionHandlerTest {
    Double testDoubleObject;

    @org.junit.Test
    public void handleDoubleObjectOption() throws Exception {
        this.testDoubleObject = new Double(0);
        DoubleObjectOptionHandler DoubleObjectOptionHandler = new DoubleObjectOptionHandler();
        DoubleObjectOptionHandler.handleOption(this.getClass().getDeclaredField("testDoubleObject"), this, "23.65");
        assertEquals(23.65, this.testDoubleObject.doubleValue(), 0.001);
    }
}