package com.ljc.threeten;

import javax.time.DayOfWeek;
import javax.time.LocalDate;
import javax.time.LocalDateTime;
import javax.time.Month;
import javax.time.ZoneId;
import javax.time.ZonedDateTime;
import javax.time.calendrical.DateAdjusters;
import javax.time.calendrical.LocalDateTimeField;

public class DateTimeCourseSetterSolutions {

	public LocalDate getLocalDateFor(int year, Month month, int day) {
		return LocalDate.of(year, month, day);
	}

	public LocalDate getLocalDateBeforeEvent(int year, Month month, int day, int daysBefore) {
		return LocalDate.of(year, month, day).minusDays(daysBefore);
	}

	public DayOfWeek getDayOfWeek(int year, Month month, int day) {
		return LocalDate.of(year, month, day).getDayOfWeek();
	}

	public long getWeekOfYear(int year, Month month, int day) {
		return LocalDate.of(year, month, day).get(LocalDateTimeField.ALIGNED_WEEK_OF_YEAR);
	}

	public DayOfWeek getLastDayOfNextMonth() {
		return LocalDate.now().plusMonths(1).with(DateAdjusters.lastDayOfMonth()).getDayOfWeek();
	}
	
	public LocalDateTime getTimeAtDate(LocalDate localDate, int hour, int minute) {
		return localDate.atTime(hour, minute, 0);
	}

	public ZonedDateTime whatTimeIsItInParisAt(ZonedDateTime dateTime) {	
		return dateTime.withZoneSameInstant(ZoneId.of("Europe/Paris"));
	}
}
