package com.ljc.threeten.clock;

import javax.time.DayOfWeek;
import javax.time.Duration;
import javax.time.Instant;
import javax.time.LocalDate;
import javax.time.LocalDateTime;
import javax.time.calendrical.LocalDateTimeField;

public class CourseSetter implements ICourseSetter {

	@Override
	public LocalDate getLocalDateFor(int year, int month, int day) {
		return LocalDate.of(year, month, day);
	}

	@Override
	public LocalDate getLocalDateBeforeEvent(int year, int month, int day, int offset) {
		return LocalDate.of(year, month, day).minusDays(offset);
	}

	@Override
	public DayOfWeek getDayOfWeek(int year, int month, int day) {
		return LocalDate.of(year, month, day).getDayOfWeek();
	}

	@Override
	public long getWeekOfYear(int year, int month, int day) {
		return LocalDate.of(year, month, day).get(LocalDateTimeField.ALIGNED_WEEK_OF_YEAR);
	}

	@Override
	public LocalDateTime getTimeAtDate(LocalDate localDate, int hour, int minute) {
		return localDate.atTime(hour, minute, 0);
	}

	@Override
	public Duration differenceBetweenDates(LocalDate startDate, LocalDate endDate) {		
		return Duration.between(Instant.from(startDate), Instant.from(endDate));		
	}

}
