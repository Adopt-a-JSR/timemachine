package com.ljc.threeten;

import static javax.time.Month.AUGUST;
import static javax.time.Month.FEBRUARY;
import static javax.time.Month.JANUARY;
import static javax.time.Month.JULY;
import static javax.time.Month.NOVEMBER;
import static javax.time.Month.SEPTEMBER;
import static junit.framework.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import javax.time.LocalDate;

import org.junit.Test;

/**
 * Test to see how date alteration works in ThreeTen.
 * <p>
 * Your goal is to make these tests pass.
 */
public class AlterationTests {

    private Alteration tool = new Alteration();

    //-----------------------------------------------------------------------
    @Test
    public void oneMonthLater() {
        assertEquals(LocalDate.of(2012, AUGUST, 10), tool.oneMonthLater(LocalDate.of(2012, JULY, 10)));
        assertEquals(LocalDate.of(2012, FEBRUARY, 29), tool.oneMonthLater(LocalDate.of(2012, JANUARY, 31)));
    }

    //-----------------------------------------------------------------------
    @Test
    public void lastDayOfMonth() {
        assertEquals(LocalDate.of(2012, JULY, 31), tool.lastDay(LocalDate.of(2012, JULY, 10)));
        assertEquals(LocalDate.of(2012, FEBRUARY, 29), tool.lastDay(LocalDate.of(2012, FEBRUARY, 10)));
    }

    //-----------------------------------------------------------------------
    @Test
    public void firstWednesday() {
        assertEquals(LocalDate.of(2012, JULY, 4), tool.firstWednesday(LocalDate.of(2012, JULY, 10)));
    }

    //-----------------------------------------------------------------------
    @Test
    public void allWednesdaysInJuly2012() {
        List<LocalDate> dateStrings = Arrays.asList(
                LocalDate.of(2012, 7, 4), LocalDate.of(2012, 7, 11), LocalDate.of(2012, 7, 18), LocalDate.of(2012, 7, 25));
        assertEquals(dateStrings, tool.allWednesdays(LocalDate.of(2012, JULY, 10)));
    }

    //-----------------------------------------------------------------------
    @Test
    public void monthsLater() {
        assertEquals(NOVEMBER, tool.monthsLater(SEPTEMBER, 2));
        assertEquals(FEBRUARY, tool.monthsLater(SEPTEMBER, 5));
    }

}
