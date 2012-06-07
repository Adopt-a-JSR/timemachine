package com.ljc.threeten.clock;

import javax.time.LocalDate;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCourseSetter {
	
	private ICourseSetter courseSetter = new CourseSetter();
	
	@Test
	public void testSetCourseForHenryVIIIDeath() {
		LocalDate henrysDeath = courseSetter.getLocalDateFor(1547, 1, 28);
		
		assertEquals("Year not correct", 1547, henrysDeath.getYear());
		assertEquals("Month not correct", 1, henrysDeath.getMonth());
		assertEquals("Day not correct", 28, henrysDeath.getDayOfMonth());
	}
	
	@Test
	public void testSetCourseForThreeDaysBeforeGunPowderPlot() {
		LocalDate powderPlotIntervention = courseSetter.getLocalDateBeforeEvent(1605, 11, 5, 3);
		
		assertEquals("Year not correct", 1605, powderPlotIntervention.getYear());
		assertEquals("Month not correct", 11, powderPlotIntervention.getMonth());
		assertEquals("Day not correct", 2, powderPlotIntervention.getDayOfMonth());
	}

}
