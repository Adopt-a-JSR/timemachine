package com.ljc.threeten.datetime.examples;

import javax.time.LocalDate;
import javax.time.LocalDateTime;

public class DateTimeCourseSetter implements IDateTimeCourseSetter {
	
	@Override
	public LocalDateTime getTimeAtDate(LocalDate localDate, int hour, int minute) {
		return localDate.atTime(hour, minute, 0);
	}
}
