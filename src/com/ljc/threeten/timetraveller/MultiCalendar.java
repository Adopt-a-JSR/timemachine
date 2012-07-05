package com.ljc.threeten.timetraveller;

import static javax.time.DayOfWeek.TUESDAY;
import static javax.time.DayOfWeek.WEDNESDAY;

import java.util.ArrayList;
import java.util.List;

import javax.time.LocalDate;
import javax.time.Month;
import javax.time.calendrical.DateAdjusters;
import javax.time.chrono.Chrono;
import javax.time.chrono.ChronoDate;
import javax.time.format.DateTimeFormatter;
import javax.time.format.DateTimeFormatters;


public class MultiCalendar implements IMultiCalendar {

    @Override
    public LocalDate firstWednesday(int year, Month month) {
        return LocalDate.of(year, month, 1).with(DateAdjusters.nextOrCurrent(WEDNESDAY));
    }

    @Override
    public List<String> allWednesdays(int year, Month month) {
        List<String> result = new ArrayList<String>();
        LocalDate first = firstWednesday(year, month);
        LocalDate date = first;
        while (date.getMonth() == first.getMonth()) {
            result.add(date.toString());
            date = date.plusWeeks(1);
        }
        return result;
    }

    @Override
    public String formattedYearMonth(String calendarSystem) {
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
