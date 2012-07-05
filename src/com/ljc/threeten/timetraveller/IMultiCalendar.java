package com.ljc.threeten.timetraveller;

import java.util.List;

import javax.time.LocalDate;
import javax.time.Month;

public interface IMultiCalendar {

    public LocalDate firstWednesday(int year, Month month);

    public List<String> allWednesdays(int year, Month month);

    public String formattedYearMonth(String calendarSystem);

    public List<String> allTuesdays(int year, int month, String calendarSystem);

}
