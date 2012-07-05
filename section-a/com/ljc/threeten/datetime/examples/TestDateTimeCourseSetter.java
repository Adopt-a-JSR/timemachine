package com.ljc.threeten.datetime.examples;

import static org.junit.Assert.assertEquals;

import javax.time.LocalDate;
import javax.time.LocalDateTime;

import org.junit.Test;

public class TestDateTimeCourseSetter {
	
	private IDateTimeCourseSetter dateTimeCourseSetter = new DateTimeCourseSetter();
	
	@Test
	public void convertADateTo3pmTime() {
		LocalDateTime localDateTime = dateTimeCourseSetter.getTimeAtDate(LocalDate.of(2000, 01, 01), 3, 52);
		
		assertEquals("Time returned is not correct", LocalDateTime.of(2000, 01, 01, 3, 52), localDateTime);
	}
}
