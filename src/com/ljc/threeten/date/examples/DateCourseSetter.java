package com.ljc.threeten.date.examples;

import javax.time.DayOfWeek;
import javax.time.LocalDate;
import javax.time.MonthOfYear;
import javax.time.calendrical.LocalDateTimeField;

public class DateCourseSetter implements IDateCourseSetter {

	@Override
	public LocalDate getLocalDateFor(int year, MonthOfYear month, int day) {
		return LocalDate.of(year, month, day);
	}

	@Override
	public LocalDate getLocalDateBeforeEvent(int year, MonthOfYear month, int day, int offset) {
		return LocalDate.of(year, month, day).minusDays(offset);
	}

	@Override
	public DayOfWeek getDayOfWeek(int year, MonthOfYear month, int day) {
		return LocalDate.of(year, month, day).getDayOfWeek();
	}

	@Override
	public long getWeekOfYear(int year, MonthOfYear month, int day) {
		return LocalDate.of(year, month, day).get(LocalDateTimeField.ALIGNED_WEEK_OF_YEAR);
	}

	@Override
	public int yearsBetweenDates(LocalDate startDate, LocalDate endDate) {		
		return endDate.getYear() - startDate.getYear();	
	}

}
