package com.ljc.threeten.intermediate;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

import java.util.List;

import javax.time.Period;
import javax.time.calendrical.LocalDateTimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;


/**
 * HINT: implement {@link ExchangeTripTests} first.
 * 
 * These tests require knowledge of timezones and also Datetimes
 */
public class SchoolHolidaysTests {

	public static SchoolHolidays londonSchoolHolidays;
	public static SchoolHolidays japanSchoolHolidays;

	@BeforeClass
	public static void setupHolidays() {
		londonSchoolHolidays = new SchoolHolidays("St. Jude's Primary", "GMT");
		japanSchoolHolidays = new SchoolHolidays("Seisen International School", "");
	}

	@Test
	public void expectedHolidayLengths() {
		assertEquals(20, londonSchoolHolidays.getHolidayLengthInDays());
		assertEquals(15, londonSchoolHolidays.getHolidayLengthInDays());
	}

	@Test
	public void expectedValidExchanges() {
		Period atLeastfiveDays = Period.of(5, LocalDateTimeUnit.DAYS);
		List<ExchangeTrip> possibleTrips = londonSchoolHolidays.findValidExchangeTrips(japanSchoolHolidays, atLeastfiveDays);
		
		assertEquals(2, possibleTrips.size());
		
		ExchangeTrip firstPossibleTrip = possibleTrips.get(0);
		assertEquals(londonSchoolHolidays.getSchoolName(), firstPossibleTrip.getHostingSchoolName());
		assertTrue(firstPossibleTrip.startsOnAWeekend());
		assertTrue(firstPossibleTrip.endsOnAWeekend());
		
		ExchangeTrip secondPossibleTrip = possibleTrips.get(1);
		assertEquals(londonSchoolHolidays.getSchoolName(), secondPossibleTrip.getHostingSchoolName());
		assertTrue(firstPossibleTrip.startsOnAWeekend());
		assertTrue(firstPossibleTrip.endsOnAWeekend());
	}

}
