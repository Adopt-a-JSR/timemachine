package com.ljc.threeten.timetraveller;

import javax.time.calendrical.CalendricalObject;
import javax.time.calendrical.DateTimeBuilder;
import javax.time.calendrical.DateTimeField;
import javax.time.calendrical.DateTimeValueRange;
import javax.time.calendrical.PeriodUnit;


public class Biorhythm implements IBiorhythm {

    @Override
    public DateTimeField physicalField() {
        return null;
    }

    @Override
    public DateTimeField emotionalField() {
        return null;
    }

    @Override
    public DateTimeField intellectualField() {
        return null;
    }

    //-----------------------------------------------------------------------
    class Adapter implements DateTimeField {
        @Override
        public String getName() {
            return null;
        }
        @Override
        public DateTimeValueRange getValueRange() {
            return null;
        }
        @Override
        public PeriodUnit getBaseUnit() {
            return null;
        }
        @Override
        public PeriodUnit getRangeUnit() {
            return null;
        }
        @Override
        public int compare(CalendricalObject calendrical1, CalendricalObject calendrical2) {
            return 0;
        }
        @Override
        public DateTimeValueRange range(CalendricalObject dateTime) {
            return null;
        }
        @Override
        public long get(CalendricalObject calendrical) {
            return 0;
        }
        @Override
        public <R extends CalendricalObject> R set(R calendrical, long newValue) {
            return null;
        }
        @Override
        public <R extends CalendricalObject> R roll(R calendrical, long roll) {
            return null;
        }
        @Override
        public boolean resolve(DateTimeBuilder builder, long value) {
            return false;
        }
    }

}
