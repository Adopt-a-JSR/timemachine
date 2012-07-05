package com.ljc.threeten.timetraveller;

import java.util.Collections;
import java.util.List;

import javax.time.calendrical.CalendricalObject;
import javax.time.calendrical.LocalDateTimeField;

public class Comparison implements IComparison {

    @Override
    public void sortByMonth(List<CalendricalObject> list) {
        Collections.sort(list, LocalDateTimeField.MONTH_OF_YEAR);
    }

}
