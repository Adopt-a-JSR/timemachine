package com.ljc.threeten.advanced;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.time.LocalDate;
import javax.time.LocalDateTime;
import javax.time.Month;
import javax.time.OffsetDate;
import javax.time.ZoneOffset;
import javax.time.calendrical.CalendricalObject;
import javax.time.extended.MonthDay;
import javax.time.extended.YearMonth;

import org.junit.Test;

import com.ljc.threeten.timetraveller.Comparison;
import com.ljc.threeten.timetraveller.IComparison;

/**
 * Test to see how sorting works in ThreeTen.
 */
public class ComparisonTests {

    private IComparison tool = new Comparison();

    //-----------------------------------------------------------------------
	@Test
	public void sort() {
	    List<CalendricalObject> cals = new ArrayList<CalendricalObject>();
	    cals.add(LocalDate.of(2012, Month.NOVEMBER, 12));
        cals.add(LocalDateTime.of(2012, Month.OCTOBER, 12, 13, 30));
        cals.add(OffsetDate.of(2012, Month.JULY, 28, ZoneOffset.ofHours(1)));
        cals.add(YearMonth.of(2012, Month.JANUARY));
        cals.add(MonthDay.of(Month.JUNE, 1));
        
        List<CalendricalObject> expected = new ArrayList<CalendricalObject>();
        expected.add(YearMonth.of(2012, Month.JANUARY));
        expected.add(MonthDay.of(Month.JUNE, 1));
        expected.add(OffsetDate.of(2012, Month.JULY, 28, ZoneOffset.ofHours(1)));
        expected.add(LocalDateTime.of(2012, Month.OCTOBER, 12, 13, 30));
        expected.add(LocalDate.of(2012, Month.NOVEMBER, 12));
        
        tool.sortByMonth(cals);        
		assertEquals(expected, cals);
	}

}
