package com.ljc.threeten.advanced;

import static javax.time.Month.JULY;
import static junit.framework.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import javax.time.LocalDate;

import org.junit.Test;

import com.ljc.threeten.timetraveller.IMultiCalendar;
import com.ljc.threeten.timetraveller.MultiCalendar;

/**
 * "Biorhythm is an attempt to predict various aspects of a person's life through simple mathematical cycles"
 * Wikipedia
 */
public class BiorhythmTests {

    private IBiorhythm tool = new Biorhythm();

    //-----------------------------------------------------------------------
	@Test
	public void calculateCycleValues() {
		assertEquals();
	}

	//-----------------------------------------------------------------------
    @Test
    public void allWednesdaysInJuly2012() {
        List<String> dateStrings = Arrays.asList("2012-07-04", "2012-07-11", "2012-07-18", "2012-07-25");
        assertEquals(dateStrings, tool.allWednesdays(2012, JULY));
    }

    //-----------------------------------------------------------------------
    @Test
    public void currentDateInCopticCalendarSystem() {
        assertEquals("1728-11", tool.formattedYearMonth("Coptic"));
    }

    //-----------------------------------------------------------------------
    @Test
    public void allWednesdaysInJuly2012InCopticCalendarSystem() {
        List<String> dateStrings = Arrays.asList("1728AM-11-03 (Coptic)", "1728AM-11-10 (Coptic)", "1728AM-11-17 (Coptic)", "1728AM-11-24 (Coptic)");
        assertEquals(dateStrings, tool.allTuesdays(1728, 11, "Coptic"));
    }

}
