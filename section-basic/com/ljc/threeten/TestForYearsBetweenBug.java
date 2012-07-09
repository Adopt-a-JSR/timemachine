package com.ljc.threeten;

import javax.time.LocalDate;
import javax.time.Month;

import org.junit.Test;
import static org.junit.Assert.*;

import static javax.time.calendrical.LocalDateTimeUnit.YEARS;

public class TestForYearsBetweenBug {

	@Test
	public void testYearsBetween() {
		LocalDate warBegins = LocalDate.of(1939, Month.SEPTEMBER, 1);
		LocalDate warEnds = LocalDate.of(1945, Month.SEPTEMBER, 2);
		
		assertEquals("This is not 6 years", 6 ,YEARS.between(warBegins, warEnds).getAmountInt());
	}
}
