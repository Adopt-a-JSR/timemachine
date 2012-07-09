package com.ljc.threeten;

import javax.time.DayOfWeek;
import javax.time.LocalDate;
import javax.time.LocalDateTime;
import javax.time.Month;
import javax.time.ZonedDateTime;

public interface IDateTimeCourseSetter {

	public LocalDate getLocalDateFor(int year, Month month, int day);

	public LocalDate getLocalDateBeforeEvent(int year, Month month, int day, int daysBefore);
	
	public DayOfWeek getDayOfWeek(int year, Month month, int day);

	public long getWeekOfYear(int year, Month month, int day);
	
	public DayOfWeek getLastDayOfNextMonth();
	
	public LocalDateTime getTimeAtDate(LocalDate localDate, int hour, int minute);
	
	public ZonedDateTime whatTimeIsItInParisAt(ZonedDateTime time);

}