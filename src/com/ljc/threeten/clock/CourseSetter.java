package com.ljc.threeten.clock;

import javax.time.LocalDate;

public class CourseSetter implements ICourseSetter {

	@Override
	public LocalDate getLocalDateFor(int year, int month, int day) {
		return LocalDate.of(year, month, day);
	}

	@Override
	public LocalDate getLocalDateBeforeEvent(int year, int month, int day, int offset) {
		return LocalDate.of(year, month, day).minusDays(offset);
	}

}
