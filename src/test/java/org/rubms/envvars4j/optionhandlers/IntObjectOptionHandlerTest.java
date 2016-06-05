package org.rubms.envvars4j.optionhandlers;

import static org.junit.Assert.assertEquals;

/**
 * Created by ruben on 5/06/16.
 */
public class IntObjectOptionHandlerTest {
    Integer testIntObject;

    @org.junit.Test
    public void handleIntObjectOption() throws Exception {
        this.testIntObject = 0;
        IntObjectOptionHandler IntObjectOptionHandler = new IntObjectOptionHandler();
        IntObjectOptionHandler.handleOption(this.getClass().getDeclaredField("testIntObject"), this, "23");
        assertEquals(23, this.testIntObject.intValue());
    }
}