package org.rubms.envvars4j.optionhandlers;

import static org.junit.Assert.assertEquals;

/**
 * Created by ruben on 5/06/16.
 */
public class IntOptionHandlerTest {
    int testIntPrimitive;

    @org.junit.Test
    public void handleIntPrimitiveOption() throws Exception {
        this.testIntPrimitive = 0;
        IntOptionHandler intOptionHandler = new IntOptionHandler();
        intOptionHandler.handleOption(this.getClass().getDeclaredField("testIntPrimitive"), this, "23");
        assertEquals(23, this.testIntPrimitive);
    }
}