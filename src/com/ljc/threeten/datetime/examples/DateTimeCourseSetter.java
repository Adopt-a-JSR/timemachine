package com.ljc.threeten.datetime.examples;

import javax.time.LocalDate;
import javax.time.LocalDateTime;
import javax.time.ZoneId;
import javax.time.ZonedDateTime;

public class DateTimeCourseSetter implements IDateTimeCourseSetter {
	
	@Override
	public LocalDateTime getTimeAtDate(LocalDate localDate, int hour, int minute) {
		return localDate.atTime(hour, minute, 0);
	}

	@Override
	public ZonedDateTime whatTimeIsItInParisAt(ZonedDateTime dateTime) {	
		return dateTime.withZoneSameInstant(ZoneId.of("Europe/Paris"));
	}
}
