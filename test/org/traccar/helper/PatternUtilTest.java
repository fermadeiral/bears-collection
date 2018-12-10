package org.traccar.helper;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PatternUtilTest {
    
    @Test
    public void testCheckPattern() {

        assertEquals("ab", PatternUtil.checkPattern("abc", "abd").getPatternMatch());

    }

}
