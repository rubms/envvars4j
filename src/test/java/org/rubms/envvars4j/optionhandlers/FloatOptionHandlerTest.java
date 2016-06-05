package org.rubms.envvars4j.optionhandlers;

import static org.junit.Assert.assertEquals;

/**
 * Created by ruben on 5/06/16.
 */
public class FloatOptionHandlerTest {
    float testFloatPrimitive;

    @org.junit.Test
    public void handleFloatPrimitiveOption() throws Exception {
        this.testFloatPrimitive = 0;
        FloatOptionHandler floatOptionHandler = new FloatOptionHandler();
        floatOptionHandler.handleOption(this.getClass().getDeclaredField("testFloatPrimitive"), this, "23.65");
        assertEquals(23.65, this.testFloatPrimitive, 0.001);
    }
}