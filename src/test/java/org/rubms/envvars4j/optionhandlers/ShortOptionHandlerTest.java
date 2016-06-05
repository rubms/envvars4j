package org.rubms.envvars4j.optionhandlers;

import static org.junit.Assert.assertEquals;

/**
 * Created by ruben on 5/06/16.
 */
public class ShortOptionHandlerTest {
    short testShortPrimitive;

    @org.junit.Test
    public void handleShortPrimitiveOption() throws Exception {
        this.testShortPrimitive = 0;
        ShortOptionHandler shortOptionHandler = new ShortOptionHandler();
        shortOptionHandler.handleOption(this.getClass().getDeclaredField("testShortPrimitive"), this, "23");
        assertEquals(23, this.testShortPrimitive);
    }
}