package com.ljc.threeten;

import javax.time.DayOfWeek;
import javax.time.LocalDate;
import javax.time.LocalDateTime;
import javax.time.Month;
import javax.time.ZonedDateTime;

public class DateTimeCourseSetter implements IDateTimeCourseSetter {

	@Override
	public LocalDate getLocalDateFor(int year, Month month, int day) {
		throw new UnsupportedOperationException();
	}

	@Override
	public LocalDate getLocalDateBeforeEvent(int year, Month month, int day, int daysBefore) {
		throw new UnsupportedOperationException();
	}

	@Override
	public DayOfWeek getDayOfWeek(int year, Month month, int day) {
		throw new UnsupportedOperationException();
	}

	@Override
	public long getWeekOfYear(int year, Month month, int day) {
		throw new UnsupportedOperationException();
	}

	@Override
	public DayOfWeek getLastDayOfNextMonth() {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public LocalDateTime getTimeAtDate(LocalDate localDate, int hour, int minute) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ZonedDateTime whatTimeIsItInParisAt(ZonedDateTime dateTime) {	
		throw new UnsupportedOperationException();
	}

}
