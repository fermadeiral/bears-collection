package com.webfirmframework.wffweb.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringBuilderUtilTest {

    @Test
    public void testGetTrimmedString() {
        StringBuilder builder = new StringBuilder();
        builder.append("         ");
        builder.append(StringUtil.join(' ', "hi", "how", "are", "you"));
        builder.append("         ");
        
        System.out.println(builder);
        
        assertEquals("hi how are you", StringBuilderUtil.getTrimmedString(builder));
    }

}
