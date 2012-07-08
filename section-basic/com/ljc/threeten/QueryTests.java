package com.ljc.threeten;

import static javax.time.Month.JULY;
import static junit.framework.Assert.assertEquals;

import javax.time.LocalDate;

import org.junit.Test;

/**
 * Test to see how date querying works in ThreeTen.
 * <p>
 * Your goal is to make these tests pass.
 */
public class QueryTests {

    private Query tool = new Query();

    //-----------------------------------------------------------------------
    @Test
    public void numberOfDaysInMonth() {
        assertEquals(31, tool.numberOfDaysInMonth(2012, 1));
        
        assertEquals(28, tool.numberOfDaysInMonth(2011, 2));
        assertEquals(29, tool.numberOfDaysInMonth(2012, 2));
        
        assertEquals(31, tool.numberOfDaysInMonth(2012, 3));
        
        assertEquals(30, tool.numberOfDaysInMonth(2012, 4));
    }

    //-----------------------------------------------------------------------
    @Test
    public void weekOfYear() {
        assertEquals(28, tool.weekOfYear(LocalDate.of(2012, JULY, 10)));
    }

}
