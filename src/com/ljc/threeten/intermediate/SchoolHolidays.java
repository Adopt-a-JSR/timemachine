package com.ljc.threeten.intermediate;

import java.util.List;

import javax.time.Period;

/**
 * Represents all the holidays for a given school called schoolName.
 */
public class SchoolHolidays {
	
	private final String schoolName;
	private final Object timeZone;
	
	public SchoolHolidays(String schoolName, String zoneId) {
		this.schoolName = schoolName;
		timeZone = null; // HINT: what is the type of timeZone?
	}

	/**
	 * Adds a holiday in a formatted string (see unit test for examples)
	 */
	public void addHoliday(String startDate, String endDate) {
		throw new UnsupportedOperationException("TODO: implement");
	}
	
	/**
	 * @return the total number of days that the school is on holiday during the year
	 */
	public long getHolidayLengthInDays() {
		throw new UnsupportedOperationException("TODO: implement");
	}

	/**
	 * Finds all the valid exchange trip options. An exchange trip is valid iff:
	 * 
	 * 1. its duration the holidays of both schools,
	 * 2. its longer than the specified minimum length of the trip,
	 * 3. the trip is a contiguous block of days,
	 * 4. its the longest trip that it can be, ie there is no other valid trip with a strict superset of the days in.
	 * 
	 * NB: you should exclude the {@link TravelTimes#getTravelTime(String, String)} from the minimumLengthOfTrip.
	 * eg: minimumLengthOfTrip = 5 days, travel time = 1 days :. total trip length = 7 days
	 * 
	 * NB: this object is considered The hosting school.
	 * 
	 * @param otherSchoolHolidays the holidays of the school that you're exchanging with.
	 * @param minimumLengthOfTrip the shortest period of time that a trip can be valid for.
	 * @return a list of the valid exchange trips sorted by order of start date
	 */
	public List<ExchangeTrip> findValidExchangeTrips(SchoolHolidays otherSchoolHolidays, Period minimumLengthOfTrip) {
		throw new UnsupportedOperationException("TODO: implement");
	}

	public String getSchoolName() {
		return schoolName;
	}

}
