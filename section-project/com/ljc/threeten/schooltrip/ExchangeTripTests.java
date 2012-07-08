package com.ljc.threeten.schooltrip;

import static javax.time.calendrical.LocalDateTimeUnit.DAYS;
import static javax.time.calendrical.LocalDateTimeUnit.HOURS;
import static junit.framework.Assert.assertEquals;

import javax.time.LocalDateTime;
import javax.time.Month;
import javax.time.Period;
import javax.time.calendrical.LocalDateTimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ljc.threeten.intermediate.ExchangeTrip;

public class ExchangeTripTests {

	private static ExchangeTrip trip;

	@BeforeClass
	public static void setupTrip() {
		LocalDateTime start = LocalDateTime.ofMidnight(2013, Month.MAY, 21);
		LocalDateTime end = LocalDateTime.ofMidnight(2013, Month.MAY, 31);
		String hostSchool = "St. Jude's Primary";
		trip = ExchangeTrip.from(hostSchool, start, end, Period.of(12, LocalDateTimeUnit.HOURS));
	}

	@Test
	public void expectedLengthOfTrip() {
		assertEquals(Period.of(10, DAYS), trip.getLengthOfTrip());
	}

	@Test
	public void expectedTotalTravel() {
		assertEquals(Period.of(24, HOURS), trip.getLengthOfTotalTravel());
	}

	@Test
	public void expectedBeginning() {
		assertEquals("21st May 2013", trip.getPrettyPrintedBeginningDate());
	}

	@Test
	public void expectedEnd() {
		assertEquals("31st May 2013", trip.getPrettyPrintedEndDate());
	}

}
