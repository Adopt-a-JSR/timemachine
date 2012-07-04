package com.ljc.threeten.intermediate;

import java.util.HashMap;
import java.util.Map;

import javax.time.Period;

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
	
	public static void addTravelTime(String originSchool, String destinationSchool, Period howLong) {
		registry.put(makeKey(originSchool, destinationSchool), howLong);
	}
	
	private static String makeKey(String fromSchool, String toSchool) {
		return fromSchool + ":" + toSchool;
	}
	
}
