package com.ljc.threeten.schooltrip;

import java.util.HashMap;
import java.util.Map;

import javax.time.Period;
import javax.time.calendrical.LocalDateTimeUnit;

/**
 * A registry of the time taken to travel between schools.
 */
public class TravelTimes {
	
	/**
	 * @return the time taken to travel between schools.
	 */
	public static Period getTravelTime(String originSchool, String destinationSchool) {
		return registry.get(makeKey(originSchool, destinationSchool));
	}

	// ------------------------------------------------------------------------------------------
	private static final Map<String, Period> registry = new HashMap<String, Period>();
	
	static {
		Period planeFlight = Period.of(12, LocalDateTimeUnit.HOURS);
		registry.put(makeKey("St. Jude's Primary", "Seisen International School"), planeFlight);
		registry.put(makeKey("Seisen International School", "St. Jude's Primary"), planeFlight);
	}
	
	private static String makeKey(String fromSchool, String toSchool) {
		return fromSchool + ":" + toSchool;
	}
	
}
