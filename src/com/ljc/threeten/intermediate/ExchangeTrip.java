package com.ljc.threeten.intermediate;

import static javax.time.calendrical.LocalDateTimeField.DAY_OF_MONTH;
import static javax.time.calendrical.LocalDateTimeField.MONTH_OF_YEAR;
import static javax.time.calendrical.LocalDateTimeField.YEAR;
import static javax.time.format.TextStyle.FULL;

import javax.time.LocalDateTime;
import javax.time.Period;
import javax.time.calendrical.CalendricalFormatter;
import javax.time.calendrical.LocalDateTimeUnit;
import javax.time.format.DateTimeFormatterBuilder;

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
		return new ExchangeTrip(hostSchool, start, end, travelTime);
	}
	
	private String hostSchool;
	private LocalDateTime start;
	private LocalDateTime end;
	private Period travelTime;
	private CalendricalFormatter formatter = new DateTimeFormatterBuilder()
													.appendText(DAY_OF_MONTH, FULL).appendLiteral("st ")
													.appendText(MONTH_OF_YEAR, FULL).appendLiteral(' ')
													.appendValue(YEAR)
													.toFormatter();

	private ExchangeTrip(String hostSchool, LocalDateTime start, LocalDateTime end, Period travelTime) {
		this.hostSchool = hostSchool;
		this.start = start;
		this.end = end;
		this.travelTime = travelTime;
	}

	public String getHostingSchoolName() {
		return hostSchool;
	}
	
	/**
	 * Return value in days, including travel time
	 */
	public Period getLengthOfTrip() {
		return LocalDateTimeUnit.DAYS.between(start, end);
	}

	/**
	 * Time taken to get to the destination + time taken to get home, provided in hours.
	 */
	public Period getLengthOfTotalTravel() {
		return travelTime.plus(travelTime);
	}
	
	/**
	 * eg: "21st May 2013"
	 */
	public String getPrettyPrintedBeginningDate() {
		return prettyPrint(start);
	}

	/**
	 * eg: "31st May 2013"
	 */
	public String getPrettyPrintedEndDate() {
		return prettyPrint(end);
	}
	
	private String prettyPrint(LocalDateTime date) {
		return date.toString(formatter);
	}

}
