package com.ljc.threeten.intermediate;


import static javax.time.calendrical.LocalDateTimeField.DAY_OF_MONTH;
import static javax.time.calendrical.LocalDateTimeField.HOUR_OF_DAY;
import static javax.time.calendrical.LocalDateTimeField.MINUTE_OF_HOUR;
import static javax.time.calendrical.LocalDateTimeField.MONTH_OF_YEAR;
import static javax.time.calendrical.LocalDateTimeField.YEAR;

import javax.time.LocalDate;
import javax.time.LocalDateTime;
import javax.time.LocalTime;
import javax.time.Period;
import javax.time.ZoneId;
import javax.time.ZonedDateTime;
import javax.time.calendrical.CalendricalFormatter;
import javax.time.calendrical.LocalDateTimeUnit;
import javax.time.format.DateTimeFormatterBuilder;

/**
 * Represents all the holidays for a given school called schoolName.
 */
public class SchoolHoliday {
	
	private static final CalendricalFormatter dateFormatter = new DateTimeFormatterBuilder()
			.appendValue(YEAR).appendLiteral('-').appendValue(MONTH_OF_YEAR)
			.appendLiteral('-').appendValue(DAY_OF_MONTH).toFormatter();

	private static final CalendricalFormatter timeFormatter = new DateTimeFormatterBuilder()
			.appendValue(HOUR_OF_DAY).appendLiteral(':')
			.appendValue(MINUTE_OF_HOUR).toFormatter();	
	
	private final String schoolName;
	private final ZoneId timeZone;
	private final ZonedDateTime start;
	private final ZonedDateTime end;
	
	public SchoolHoliday(String schoolName, String zoneId, String startDate, String startTime, String endDate, String endTime) {
		this.schoolName = schoolName;
		timeZone = ZoneId.of(zoneId);
		start = parse(startDate, startTime);
		end = parse(endDate, endTime);
	}
	
	private ZonedDateTime parse(String dateStr, String timeStr) {
		LocalDate date = LocalDate.parse(dateStr, dateFormatter);
		LocalTime time = LocalTime.parse(timeStr, timeFormatter);
		return ZonedDateTime.of(date, time, timeZone);
	}

	/**
	 * @return the total number of days that the school is on holiday during the year
	 */
	public int getHolidayLengthInDays() {
		return LocalDateTimeUnit.DAYS.between(start, end).getAmountInt();
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
	 * @return a valid exchange trip if its possible to get one
	 * @throws an IllegalArgumentException if its not possible
	 */
	public ExchangeTrip getTripFromOverlap(SchoolHoliday otherSchoolHolidays, Period minimumLengthOfTrip) {
		String otherSchool = otherSchoolHolidays.getSchoolName();
		Period travelTime = TravelTimes.getTravelTime(schoolName, otherSchool);
		travelTime = travelTime.plus(travelTime); // Trip there and back
		Period minimumHolidayLength = minimumLengthOfTrip.minus(travelTime);
		
		// Convert time zones
		ZonedDateTime otherStart = otherSchoolHolidays.start.withZoneSameInstant(this.timeZone);
		ZonedDateTime otherEnd = otherSchoolHolidays.end.withZoneSameInstant(this.timeZone);
		
		// get interval start and end times
		LocalDateTime start = getLater(this.start, otherStart);
		LocalDateTime end = getEarlier(this.end, otherEnd);
		Period holidayDuration = minimumHolidayLength.getUnit().between(start, end);

		int isValidLength = holidayDuration.compareTo(minimumHolidayLength);
		if (isValidLength > 1) {
			throw new IllegalArgumentException("There is insufficient overlap in dates");
		}
		
		return ExchangeTrip.from(schoolName, start, end, travelTime);
	}
	
	private LocalDateTime getEarlier(ZonedDateTime a, ZonedDateTime b) {
		if (a.isBefore(b)) {
			return a.toLocalDateTime();
		} else {
			return b.toLocalDateTime();
		}
	}
	
	private LocalDateTime getLater(ZonedDateTime a, ZonedDateTime b) {
		if (a.isAfter(b)) {
			return a.toLocalDateTime();
		} else {
			return b.toLocalDateTime();
		}
	}

	private Period getMinimumHolidayLength(SchoolHoliday otherSchoolHolidays, Period minimumLengthOfTrip) {
		String otherSchool = otherSchoolHolidays.getSchoolName();
		Period travelTime = TravelTimes.getTravelTime(schoolName, otherSchool);
		travelTime = travelTime.plus(travelTime); // Trip there and back
		return minimumLengthOfTrip.minus(travelTime);
	}

	public String getSchoolName() {
		return schoolName;
	}

}
