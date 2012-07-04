package com.ljc.threeten.intermediate;

import static junit.framework.Assert.assertEquals;

import javax.time.Period;
import javax.time.calendrical.LocalDateTimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * HINT: implement {@link ExchangeTripTests} first.
 * 
 * These tests require knowledge of timezones and also Datetimes
 */
public class SchoolHolidayTests {

	public static SchoolHoliday londonSchoolHoliday;
	public static SchoolHoliday japanSchoolHoliday;

	@BeforeClass
	public static void setupHolidays() {
		londonSchoolHoliday = new SchoolHoliday("St. Jude's Primary", "GMT", "", "");
		japanSchoolHoliday = new SchoolHoliday("Seisen International School", "JST", "", "");
	}

	@Test
	public void expectedHolidayLengths() {
		assertEquals(20, londonSchoolHoliday.getHolidayLengthInDays());
		assertEquals(15, londonSchoolHoliday.getHolidayLengthInDays());
	}

	@Test
	public void expectedValidExchanges() {
		Period atLeastfiveDays = Period.of(5, LocalDateTimeUnit.DAYS);
		ExchangeTrip possibleTrip = londonSchoolHoliday.getTripFromOverlap(japanSchoolHoliday, atLeastfiveDays);
		
		assertEquals(londonSchoolHoliday.getSchoolName(), possibleTrip.getHostingSchoolName());
		assertEquals("", possibleTrip.getPrettyPrintedBeginningDate());
		assertEquals("", possibleTrip.getPrettyPrintedEndDate());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void expectedInvalidExchanges() {
		Period atLeastfiveDays = Period.of(15, LocalDateTimeUnit.DAYS);
		ExchangeTrip possibleTrip = londonSchoolHoliday.getTripFromOverlap(japanSchoolHoliday, atLeastfiveDays);
	}

}
