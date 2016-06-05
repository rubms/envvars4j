package org.rubms.envvars4j.optionhandlers;

import static org.junit.Assert.*;

/**
 * Created by ruben on 5/06/16.
 */
public class BooleanOptionHandlerTest {
    boolean testBooleanPrimitive;

    @org.junit.Test
    public void handleBooleanPrimitiveOption() throws Exception {
        this.testBooleanPrimitive = false;
        BooleanOptionHandler booleanOptionHandler = new BooleanOptionHandler();
        booleanOptionHandler.handleOption(this.getClass().getDeclaredField("testBooleanPrimitive"), this, "true");
        assertEquals(true, this.testBooleanPrimitive);
    }
}