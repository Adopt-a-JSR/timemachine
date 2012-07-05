package com.ljc.threeten;

import static javax.time.DayOfWeek.WEDNESDAY;

import java.util.ArrayList;
import java.util.List;

import javax.time.LocalDate;
import javax.time.Month;
import javax.time.calendrical.DateAdjusters;

/**
 * Solution to the task.
 * See {@link AlterationTests}.
 */
public class AlterationSolution extends Alteration {

    @Override
    public LocalDate oneMonthLater(LocalDate baseDate) {
        return baseDate.plusMonths(1);
    }

    @Override
    public LocalDate lastDay(LocalDate baseDate) {
        return baseDate.with(DateAdjusters.lastDayOfMonth());
    }

    @Override
    public LocalDate firstWednesday(LocalDate baseDate) {
        return baseDate.with(DateAdjusters.firstInMonth(WEDNESDAY));
    }

    @Override
    public List<LocalDate> allWednesdays(LocalDate baseDate) {
        List<LocalDate> result = new ArrayList<LocalDate>();
        LocalDate first = firstWednesday(baseDate);
        LocalDate date = first;
        while (date.getMonth() == first.getMonth()) {
            result.add(date);
            date = date.plusWeeks(1);
        }
        return result;
    }

    @Override
    public Month monthsLater(Month baseMonth, int numberOfMonthsLater) {
        return baseMonth.roll(numberOfMonthsLater);
    }

}
