package org.rubms.envvars4j.optionhandlers;

import static org.junit.Assert.assertEquals;

/**
 * Created by ruben on 5/06/16.
 */
public class ShortObjectOptionHandlerTest {
    Short testShortObject;

    @org.junit.Test
    public void handleShortObjectOption() throws Exception {
        this.testShortObject = 0;
        ShortObjectOptionHandler ShortObjectOptionHandler = new ShortObjectOptionHandler();
        ShortObjectOptionHandler.handleOption(this.getClass().getDeclaredField("testShortObject"), this, "23");
        assertEquals(23, this.testShortObject.shortValue());
    }
}