package com.ljc.threeten.clock;

import javax.time.LocalDate;

public interface ICourseSetter {

	public LocalDate getLocalDateFor(int year, int month, int day);

	public LocalDate getLocalDateBeforeEvent(int year, int month, int day, int offset);

}
