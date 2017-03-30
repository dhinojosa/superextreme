package com.xyzcorp;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;

public class CalcStatsTest {
	
	@Test
	public void testMaxOfOneItem() {
	    CalcStats cs = new CalcStats(new int[]{5});
		Optional<Integer> result = cs.getMaximum();
	    assertEquals(Optional.of(5), result);			
	}

	@Test
	public void testMaxOfTwoPositiveItems() {
	    CalcStats cs = new CalcStats(new int[]{5, 10});
		Optional<Integer> result = cs.getMaximum();
	    assertEquals(Optional.of(10), result);			
	}

	@Test
	public void testEmptyArray() {
		CalcStats cs = new CalcStats(new int[]{});
		Optional<Integer> result = cs.getMaximum();
		assertEquals(Optional.empty(), result);
	}
	
	//NotPreferred
	@Test
	public void testNullClassicOldWay() {
		try {
		    new CalcStats(null); 
		    fail("The previous should not be successful");
		} catch (NullPointerException npe) {
		   assertTrue(true);
		}
	}

    //NotPreferred
	@Test(expected = NullPointerException.class)
	public void testNullClassicOldWayAnnotation() {
		new CalcStats(null); 
	}
	
	@Test
	public void testNullClassicWay() {
		try {
		    new CalcStats(null); 
		    fail("The previous should not be successful");
		} catch (NullPointerException npe) {
		    assertEquals(npe.getMessage(), "array cannot be null");
		}
	}
	
	
	
}
