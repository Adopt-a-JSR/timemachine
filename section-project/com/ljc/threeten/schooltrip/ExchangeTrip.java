package com.ljc.threeten.schooltrip;

import javax.time.LocalDateTime;
import javax.time.Period;

/**
 * Information for pupils about an exchange trip.
 * 
 * Exchange trips comprise a contiguous block of days.
 */
public class ExchangeTrip {
	
	/**
	 * Factory method for making example ExchangeTrip instances. 
	 * 
	 * @param start the time when children are picked up by their parents
	 * @param end the time when children are picked up by their parents
	 * @param travelTime the time taken to travel one way between origin and destination
	 * @return
	 */
	public static ExchangeTrip from(String hostSchool, LocalDateTime start, LocalDateTime end, Period travelTime) {
		throw new UnsupportedOperationException();
	}

	public String getHostingSchoolName() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Return value in days, including travel time
	 */
	public Period getLengthOfTrip() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Time taken to get to the destination + time taken to get home, provided in hours.
	 */
	public Period getLengthOfTotalTravel() {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * eg: "21st May 2013"
	 */
	public String getPrettyPrintedBeginningDate() {
		throw new UnsupportedOperationException();
	}

	/**
	 * eg: "31st May 2013"
	 */
	public String getPrettyPrintedEndDate() {
		throw new UnsupportedOperationException();
	}

}
