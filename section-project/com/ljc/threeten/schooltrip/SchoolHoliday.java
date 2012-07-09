package com.ljc.threeten.schooltrip;


import javax.time.Period;

/**
 * Represents all the holidays for a given school called schoolName.
 */
public class SchoolHoliday {
	
	public SchoolHoliday(String schoolName, String zoneId, String startDate, String startTime, String endDate, String endTime) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return the total number of days that the school is on holiday during the year
	 */
	public int getHolidayLengthInDays() {
		throw new UnsupportedOperationException();
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
	 * @param minimumLengthOfTrip the shortest period of time that the trip can take in total.
	 * @return a valid exchange trip if its possible to get one
	 * @throws an IllegalArgumentException if its not possible
	 */
	public ExchangeTrip getTripFromOverlap(SchoolHoliday otherSchoolHolidays, Period minimumLengthOfTrip) {
		throw new UnsupportedOperationException();
	}

	public String getSchoolName() {
		throw new UnsupportedOperationException();
	}

}
