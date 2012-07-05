package com.ljc.threeten.date.examples;

import javax.time.DayOfWeek;
import javax.time.LocalDate;
import javax.time.Month;

public interface IDateCourseSetter {

	public LocalDate getLocalDateFor(int year, Month month, int day);

	public LocalDate getLocalDateBeforeEvent(int year, Month month, int day, int offset);
	
	public DayOfWeek getDayOfWeek(int year, Month month, int day);

	public long getWeekOfYear(int year, Month month, int day);

	public int yearsBetweenDates(LocalDate startDate, LocalDate endDate);

}