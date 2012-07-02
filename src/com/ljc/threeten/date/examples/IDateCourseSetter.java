package com.ljc.threeten.date.examples;

import javax.time.DayOfWeek;
import javax.time.LocalDate;
import javax.time.MonthOfYear;

public interface IDateCourseSetter {

	public LocalDate getLocalDateFor(int year, MonthOfYear month, int day);

	public LocalDate getLocalDateBeforeEvent(int year, MonthOfYear month, int day, int offset);
	
	public DayOfWeek getDayOfWeek(int year, MonthOfYear month, int day);

	public long getWeekOfYear(int year, MonthOfYear month, int day);

	public int yearsBetweenDates(LocalDate startDate, LocalDate endDate);

}