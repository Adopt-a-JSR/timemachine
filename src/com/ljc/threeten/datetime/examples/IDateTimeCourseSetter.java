package com.ljc.threeten.datetime.examples;

import javax.time.LocalDate;
import javax.time.LocalDateTime;
import javax.time.ZonedDateTime;

public interface IDateTimeCourseSetter {
	
	public LocalDateTime getTimeAtDate(LocalDate localDate, int hour, int minute);
	
	public ZonedDateTime whatTimeIsItInParisAt(ZonedDateTime time);
}
