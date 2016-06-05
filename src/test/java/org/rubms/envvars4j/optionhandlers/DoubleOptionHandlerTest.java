package org.rubms.envvars4j.optionhandlers;

import static org.junit.Assert.assertEquals;

/**
 * Created by ruben on 5/06/16.
 */
public class DoubleOptionHandlerTest {
    double testDoublePrimitive;

    @org.junit.Test
    public void handleDoublePrimitiveOption() throws Exception {
        this.testDoublePrimitive = 0;
        DoubleOptionHandler doubleOptionHandler = new DoubleOptionHandler();
        doubleOptionHandler.handleOption(this.getClass().getDeclaredField("testDoublePrimitive"), this, "23.65");
        assertEquals(23.65, this.testDoublePrimitive, 0.001);
    }
}