package com.ljc.threeten;

import static javax.time.calendrical.LocalDateTimeUnit.YEARS;

import javax.time.DayOfWeek;
import javax.time.LocalDate;
import javax.time.LocalDateTime;
import javax.time.Month;
import javax.time.ZoneId;
import javax.time.ZonedDateTime;
import javax.time.calendrical.DateAdjusters;
import javax.time.calendrical.LocalDateTimeField;

public class DateTimeCourseSetter implements IDateTimeCourseSetter {

	@Override
	public LocalDate getLocalDateFor(int year, Month month, int day) {
		return LocalDate.of(year, month, day);
	}

	@Override
	public LocalDate getLocalDateBeforeEvent(int year, Month month, int day, int daysBefore) {
		return LocalDate.of(year, month, day).minusDays(daysBefore);
	}

	@Override
	public DayOfWeek getDayOfWeek(int year, Month month, int day) {
		return LocalDate.of(year, month, day).getDayOfWeek();
	}

	@Override
	public long getWeekOfYear(int year, Month month, int day) {
		return LocalDate.of(year, month, day).get(LocalDateTimeField.ALIGNED_WEEK_OF_YEAR);
	}

	@Override
	public DayOfWeek getLastDayOfNextMonth() {
		return LocalDate.now().plusMonths(1).with(DateAdjusters.lastDayOfMonth()).getDayOfWeek();
	}
	
	@Override
	public LocalDateTime getTimeAtDate(LocalDate localDate, int hour, int minute) {
		return localDate.atTime(hour, minute, 0);
	}

	@Override
	public ZonedDateTime whatTimeIsItInParisAt(ZonedDateTime dateTime) {	
		return dateTime.withZoneSameInstant(ZoneId.of("Europe/Paris"));
	}

}
