package org.xbib.jdbc.input;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by sanyu on 2017/9/7.
 */
public class InputTest {

    @Test
    public void testInputInit(){
        Input input = new InputImpl();
        input.init();
        assertEquals("1", "1");
    }

}
