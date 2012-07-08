package com.ljc.threeten;

import javax.time.DateTimes;
import javax.time.LocalDate;
import javax.time.Month;
import javax.time.calendrical.LocalDateTimeField;

/**
 * Solution to the task.
 * See {@link QueryTests}.
 */
public class QuerySolution extends Query {

    @Override
    public int numberOfDaysInMonth(int year, int month) {
        return Month.of(month).lengthInDays(DateTimes.isLeapYear(year));
    }

    @Override
    public long weekOfYear(LocalDate date) {
        return date.get(LocalDateTimeField.ALIGNED_WEEK_OF_YEAR);
    }

}
