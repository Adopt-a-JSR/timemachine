package com.ljc.threeten.clock;

import javax.time.DayOfWeek;
import javax.time.Duration;
import javax.time.LocalDate;
import javax.time.LocalDateTime;

public interface ICourseSetter {

	public LocalDate getLocalDateFor(int year, int month, int day);

	public LocalDate getLocalDateBeforeEvent(int year, int month, int day, int offset);
	
	public DayOfWeek getDayOfWeek(int year, int month, int day);

	public long getWeekOfYear(int year, int month, int day);

	public LocalDateTime getTimeAtDate(LocalDate localDate, int hour, int minute);

	public Duration differenceBetweenDates(LocalDate startDate, LocalDate endDate);

}