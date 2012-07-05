package com.ljc.threeten;

import static javax.time.DayOfWeek.TUESDAY;

import java.util.ArrayList;
import java.util.List;

import javax.time.chrono.Chrono;
import javax.time.chrono.ChronoDate;
import javax.time.format.DateTimeFormatter;
import javax.time.format.DateTimeFormatters;

/**
 * Solution to the task.
 * See {@link MultiCalendarTests}.
 */
public class MultiCalendarSolution extends MultiCalendar {

    @Override
    public Object findCalendar(String calendarSystem) {
        return Chrono.ofName(calendarSystem);
    }

    @Override
    public String formattedCurrentDateYearMonth(String calendarSystem) {
        ChronoDate date = Chrono.ofName(calendarSystem).now();
        DateTimeFormatter f = DateTimeFormatters.pattern("yyyy-MM");
        return f.print(date);
    }

    @Override
    public List<String> allTuesdays(int year, int month, String calendarSystem) {
        ChronoDate first = Chrono.ofName(calendarSystem).date(year, month, 1);
        first = first.withDayOfWeek(TUESDAY);
        if (first.getMonth() < month) {
            first = first.plusWeeks(1);
        }
        List<String> result = new ArrayList<String>();
        ChronoDate date = first;
        while (date.getMonth() == first.getMonth()) {
            result.add(date.toString());
            date = date.plusWeeks(1);
        }
        return result;
    }

}
