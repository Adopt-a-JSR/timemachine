package com.ljc.threeten.schooltrip;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

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
	public static SchoolHoliday japaneseSchoolHoliday;

	@BeforeClass
	public static void setupHolidays() {
		londonSchoolHoliday = new SchoolHoliday("St. Jude's Primary", "Europe/London",
				"2012-07-03","10:15",
				"2012-07-23","22:15");
		japaneseSchoolHoliday = new SchoolHoliday(
				"Seisen International School", "Asia/Tokyo",
				"2012-07-10", "9:00",
				"2012-07-25", "11:00");
	}

	@Test
	public void expectedHolidayLengths() {
		assertEquals(20, londonSchoolHoliday.getHolidayLengthInDays());
		assertEquals(15, japaneseSchoolHoliday.getHolidayLengthInDays());
	}

	@Test
	public void expectedValidExchanges() {
		Period atLeastFiveDays = Period.of(120, LocalDateTimeUnit.HOURS);
		ExchangeTrip possibleTrip = londonSchoolHoliday.getTripFromOverlap(japaneseSchoolHoliday, atLeastFiveDays);
		
		assertEquals(londonSchoolHoliday.getSchoolName(), possibleTrip.getHostingSchoolName());
		String beginningDate = possibleTrip.getPrettyPrintedBeginningDate();
		assertTrue(beginningDate.contains("July 2012"));
		assertTrue(beginningDate.contains("10"));
		
		String endDate = possibleTrip.getPrettyPrintedEndDate();
		assertTrue(endDate.contains("July 2012"));
		assertTrue(endDate.contains("23"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void expectedInvalidExchanges() {
		Period atLeastFifteenDays = Period.of(360, LocalDateTimeUnit.HOURS);
		londonSchoolHoliday.getTripFromOverlap(japaneseSchoolHoliday, atLeastFifteenDays);
	}

}
