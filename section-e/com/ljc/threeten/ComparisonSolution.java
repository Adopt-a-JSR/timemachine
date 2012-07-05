package com.ljc.threeten;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.time.LocalDate;
import javax.time.calendrical.CalendricalObject;
import javax.time.calendrical.LocalDateTimeField;

/**
 * Solution to the task.
 * See {@link ComparisonTests}.
 */
public class ComparisonSolution extends Comparison {

    @Override
    public void sortByMonth(List<CalendricalObject> list) {
        Collections.sort(list, LocalDateTimeField.MONTH_OF_YEAR);
    }

    @Override
    public void sortByDate(List<CalendricalObject> cals) {
        Collections.sort(cals, new Comparator<CalendricalObject>() {
            @Override
            public int compare(CalendricalObject obj1, CalendricalObject obj2) {
                return obj1.extract(LocalDate.class).compareTo(obj2.extract(LocalDate.class));
            }
        });
    }

}
