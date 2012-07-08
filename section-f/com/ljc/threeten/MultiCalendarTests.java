package com.ljc.threeten;

import static junit.framework.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Test to see how calendar systems other than our own work in ThreeTen.
 * <p>
 * Your goal is to make these tests pass.
 */
public class MultiCalendarTests {

    private MultiCalendar tool = new MultiCalendar();

    //-----------------------------------------------------------------------
    @Test
    public void findCalendar() {
        assertEquals(Cheat.COPTIC, tool.findCalendar("Coptic"));
    }

    //-----------------------------------------------------------------------
    @Test
    public void currentDateInCopticCalendarSystem() {
        assertEquals("1728-11", tool.formattedCurrentDateYearMonth("Coptic"));
    }

    //-----------------------------------------------------------------------
    @Test
    public void allWednesdaysInJuly2012InCopticCalendarSystem() {
        List<String> dateStrings = Arrays.asList("1728AM-11-03 (Coptic)", "1728AM-11-10 (Coptic)", "1728AM-11-17 (Coptic)", "1728AM-11-24 (Coptic)");
        assertEquals(dateStrings, tool.allTuesdays(1728, 11, "Coptic"));
    }

}
