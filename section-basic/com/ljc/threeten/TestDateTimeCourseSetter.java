package com.ljc.threeten;

import static org.junit.Assert.assertEquals;

import javax.time.DayOfWeek;
import javax.time.LocalDate;
import javax.time.LocalDateTime;
import javax.time.Month;
import javax.time.ZoneId;
import javax.time.ZonedDateTime;

import org.junit.Test;


public class TestDateTimeCourseSetter {
	
	private IDateTimeCourseSetter dateCourseSetter = new DateTimeCourseSetter();
	
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
	
	//Hard coded unit test to not reveal answer :-)
	@Test
	public void getLastDayOfNextMonth() {
		assertEquals("Last day of Next month is Friday", DayOfWeek.FRIDAY, 
				dateCourseSetter.getLastDayOfNextMonth());
	}
	
	@Test
	public void convertADateTo3pmTime() {
		LocalDateTime localDateTime = dateCourseSetter.getTimeAtDate(LocalDate.of(2000, 01, 01), 3, 52);		
		assertEquals("Time returned is not correct", LocalDateTime.of(2000, 01, 01, 3, 52), localDateTime);
	}
	
	@Test
	public void testDateTimeInParis() {
		LocalDateTime now = LocalDateTime.now();
		ZonedDateTime zonedTime = ZonedDateTime.of(now, ZoneId.of("Europe/London"));
		ZonedDateTime timeInParis = dateCourseSetter.whatTimeIsItInParisAt(zonedTime);
		
		assertEquals("Time returned is not one hour later", now.getHour() + 1, timeInParis.getHour());
		assertEquals("Minute returned is not the same", now.getMinute(), timeInParis.getMinute());
		assertEquals("Seconds returned is not the same", now.getMinute(), timeInParis.getMinute());
	}
}
