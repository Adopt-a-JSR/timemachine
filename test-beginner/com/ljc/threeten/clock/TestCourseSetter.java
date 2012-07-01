package com.ljc.threeten.clock;

import javax.time.DayOfWeek;
import javax.time.Duration;
import javax.time.LocalDate;
import javax.time.LocalDateTime;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCourseSetter {
	
	private ICourseSetter courseSetter = new CourseSetter();
	
	@Test
	public void testSetCourseForHenryVIIIDeath() {
		LocalDate henrysDeath = courseSetter.getLocalDateFor(1547, 1, 28);
		
		assertEquals("Year not correct", 1547, henrysDeath.getYear());
		assertEquals("Month not correct", 1, henrysDeath.getMonth());
		assertEquals("Day not correct", 28, henrysDeath.getDayOfMonth());
	}
	
	@Test
	public void testSetCourseForThreeDaysBeforeGunPowderPlot() {
		LocalDate powderPlotIntervention = courseSetter.getLocalDateBeforeEvent(1605, 11, 5, 3);
		
		assertEquals("Year not correct", 1605, powderPlotIntervention.getYear());
		assertEquals("Month not correct", 11, powderPlotIntervention.getMonth());
		assertEquals("Day not correct", 2, powderPlotIntervention.getDayOfMonth());
	}
	
	@Test
	public void whatDayWasItOn13September2011() {
		DayOfWeek dayOfWeek = courseSetter.getDayOfWeek(2011, 9, 13);
		
		assertEquals("Day of week is not correct", DayOfWeek.TUESDAY, dayOfWeek);
	}
	
	@Test
	public void whatIsTheWeekWithinAYearOf13September2011() {
		long weekOfYear = courseSetter.getWeekOfYear(2011, 9, 13);
		
		assertEquals("Week of year is not correct", 37, weekOfYear);
	}
	
	@Test
	public void durationOfWorldWarII() {
		LocalDate warBegins = LocalDate.of(1939, 9, 1);
		LocalDate warEnds = LocalDate.of(1945, 9, 2);
		
		Duration duration = courseSetter.differenceBetweenDates(warBegins, warEnds);
		
		//FIXME Double check this is the right approach and formulate asserts
	}
	
	@Test
	public void convertADateTo3pmTime() {
		LocalDateTime localDateTime = courseSetter.getTimeAtDate(LocalDate.of(2000, 01, 01), 3, 52);
		
		assertEquals("Time returned is not correct", LocalDateTime.of(2000, 01, 01, 3, 52), localDateTime);
	}
}
