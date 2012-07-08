package com.ljc.threeten.datetime.examples;

import static org.junit.Assert.assertEquals;

import javax.time.LocalDate;
import javax.time.LocalDateTime;
import javax.time.ZoneId;
import javax.time.ZonedDateTime;

import org.junit.Test;

public class TestDateTimeCourseSetter {
	
	private IDateTimeCourseSetter dateTimeCourseSetter = new DateTimeCourseSetter();
	
	@Test
	public void convertADateTo3pmTime() {
		LocalDateTime localDateTime = dateTimeCourseSetter.getTimeAtDate(LocalDate.of(2000, 01, 01), 3, 52);		
		assertEquals("Time returned is not correct", LocalDateTime.of(2000, 01, 01, 3, 52), localDateTime);
	}
	
	@Test
	public void testDateTimeInParis() {
		LocalDateTime now = LocalDateTime.now();
		ZonedDateTime zonedTime = ZonedDateTime.of(now, ZoneId.of("Europe/London"));
		ZonedDateTime timeInParis = dateTimeCourseSetter.whatTimeIsItInParisAt(zonedTime);
		
		assertEquals("Time returned is not one hour later", now.getHour() + 1, timeInParis.getHour());
		assertEquals("Minute returned is not the same", now.getMinute(), timeInParis.getMinute());
		assertEquals("Seconds returned is not the same", now.getMinute(), timeInParis.getMinute());
	}
}
