package com.ljc.threeten;

import java.util.List;

import javax.time.LocalDate;
import javax.time.Month;

/**
 * Stub class to be implemented.
 * See {@link AlterationTests}.
 * */
public class Alteration {

    /**
     * Adjust the supplied date to be one month later.
     * 
     * @param baseDate  the base date
     * @return the altered date
     */
    public LocalDate oneMonthLater(LocalDate baseDate) {
        throw new UnsupportedOperationException();
    }

    /**
     * Adjust the supplied date to have the last day of the month.
     * 
     * @param baseDate  the base date
     * @return the altered date
     */
    public LocalDate lastDay(LocalDate baseDate) {
        throw new UnsupportedOperationException();
    }

    /**
     * Adjust the supplied date to have the first Wednesday of the month.
     * 
     * @param baseDate  the base date
     * @return the altered date
     */
    public LocalDate firstWednesday(LocalDate baseDate) {
        throw new UnsupportedOperationException();
    }

    /**
     * Finds all the Wednesdays in a month.
     * 
     * @param baseDate  the base date
     * @return the list of dates
     */
    public List<LocalDate> allWednesdays(LocalDate baseDate) {
        throw new UnsupportedOperationException();
    }

    /**
     * Gets the month that is the specified number of months later.
     * 
     * @param baseMonth  the base month
     * @param numberOfMonthsLater  the number of months to add
     * @return the resultant month
     */
    public Month monthsLater(Month baseMonth, int numberOfMonthsLater) {
        throw new UnsupportedOperationException();
    }

}
