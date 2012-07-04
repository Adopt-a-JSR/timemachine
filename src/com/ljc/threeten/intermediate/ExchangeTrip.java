package com.ljc.threeten.intermediate;

import java.util.Comparator;

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
		throw new UnsupportedOperationException("TODO: implement");
	}
	
	private String hostSchool;
	
	// TODO: write constructor

	public boolean startsOnAWeekend() {
		throw new UnsupportedOperationException("TODO: implement");
	}

	public boolean endsOnAWeekend() {
		throw new UnsupportedOperationException("TODO: implement");
	}

	public String getHostingSchoolName() {
		return hostSchool;
	}
	
	/**
	 * Including travel time
	 */
	public Period getLengthOfTrip() {
		throw new UnsupportedOperationException("TODO: implement");
	}
	
	/**
	 * Time taken to get to the destination + time taken to get home.
	 */
	public Period getLengthOfTotalTravel() {
		throw new UnsupportedOperationException("TODO: implement");
	}
	
	/**
	 * eg: "21st May 2013"
	 */
	public String getPrettyPrintedBeginningDate() {
		throw new UnsupportedOperationException("TODO: implement");
	}

	/**
	 * eg: "31st May 2013"
	 */
	public String getPrettyPrintedEndDate() {
		throw new UnsupportedOperationException("TODO: implement");
	}

	/**
	 * Air transport is cheaper on a weekday.
	 */
	public static final Comparator<ExchangeTrip> COST_COMPARATOR = new Comparator<ExchangeTrip>() {
		@Override
		public int compare(ExchangeTrip trip1, ExchangeTrip trip2) {
			return Integer.compare(trip1.getCostScore(), trip2.getCostScore());
		}
	};

	private int getCostScore() {
		return (startsOnAWeekend() ? 0 : 1) + (endsOnAWeekend() ? 0 : 1);
	}

}
