package org.rubms.envvars4j.optionhandlers;

import static org.junit.Assert.*;

/**
 * Created by ruben on 5/06/16.
 */
public class BooleanObjectOptionHandlerTest {
    Boolean testBooleanObject;

    @org.junit.Test
    public void handleBooleanObjectOption() throws Exception {
        this.testBooleanObject = new Boolean(false);
        BooleanObjectOptionHandler booleanObjectOptionHandler = new BooleanObjectOptionHandler();
        booleanObjectOptionHandler.handleOption(this.getClass().getDeclaredField("testBooleanObject"), this, "true");
        assertEquals(true, this.testBooleanObject.booleanValue());
    }
}