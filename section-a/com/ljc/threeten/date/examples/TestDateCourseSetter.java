package com.ljc.threeten.date.examples;

import static org.junit.Assert.assertEquals;

import javax.time.DayOfWeek;
import javax.time.LocalDate;
import javax.time.Month;

import org.junit.Test;

public class TestDateCourseSetter {
	
	private IDateCourseSetter dateCourseSetter = new DateCourseSetter();
	
	@Test
	public void testSetCourseForHenryVIIIDeath() {
		LocalDate henrysDeath = dateCourseSetter.getLocalDateFor(1547, Month.JANUARY, 28);
		
		assertEquals("Year not correct", 1547, henrysDeath.getYear());
		assertEquals("Month not correct", Month.JANUARY, henrysDeath.getMonth());
		assertEquals("Day not correct", 28, henrysDeath.getDayOfMonth());
	}
	
	@Test
	public void testSetCourseForThreeDaysBeforeGunPowderPlot() {
		LocalDate powderPlotIntervention = dateCourseSetter.getLocalDateBeforeEvent(1605, Month.NOVEMBER, 5, 3);
		
		assertEquals("Year not correct", 1605, powderPlotIntervention.getYear());
		assertEquals("Month not correct", Month.NOVEMBER, powderPlotIntervention.getMonth());
		assertEquals("Day not correct", 2, powderPlotIntervention.getDayOfMonth());
	}
	
	@Test
	public void whatDayWasItOn13September2011() {
		DayOfWeek dayOfWeek = dateCourseSetter.getDayOfWeek(2011, Month.SEPTEMBER, 13);
		
		assertEquals("Day of week is not correct", DayOfWeek.TUESDAY, dayOfWeek);
	}
	
	@Test
	public void whatIsTheWeekWithinAYearOf13September2011() {
		long weekOfYear = dateCourseSetter.getWeekOfYear(2011, Month.SEPTEMBER, 13);
		
		assertEquals("Week of year is not correct", 37, weekOfYear);
	}
	
	@Test
	public void yearsOfWorldWarII() {
		LocalDate warBegins = LocalDate.of(1939, Month.SEPTEMBER, 1);
		LocalDate warEnds = LocalDate.of(1945, Month.SEPTEMBER, 2);		
		int numberOfYears = dateCourseSetter.yearsBetweenDates(warBegins, warEnds);
		
		assertEquals("Number of years is not 6", 6, numberOfYears);
	}
	
	//Hard coded unit test to not reveal answer :-)
	@Test
	public void getLastDayOfNextMonth() {
		assertEquals("Last day of Next month is Friday", DayOfWeek.FRIDAY, 
				dateCourseSetter.getLastDayOfNextMonth());
	}
}
