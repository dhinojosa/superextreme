package com.xyzcorp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testNullUsingRule() {
		thrown.expect(NullPointerException.class);
		thrown.expectMessage("array cannot be null");
		new CalcStats(null);
	}
	
	//Non red-bar
	@Test
	public void testMaxOfTwoPositiveFirstItemGreaterThanSecond() {
	    CalcStats cs = new CalcStats(new int[]{10, 5});
		Optional<Integer> result = cs.getMaximum();
	    assertEquals(Optional.of(10), result);			
	}
	
	@Test
	public void testMaxOfThreePositiveMaxIsTheLastElement() {
	    CalcStats cs = new CalcStats(new int[]{10, 5, 40});
		Optional<Integer> result = cs.getMaximum();
	    assertEquals(Optional.of(40), result);			
	}
	
	//NoRedBar
	@Test
	public void testMaxOfFourItemsAllNegativeExceptOneZero() {
	    CalcStats cs = new CalcStats(new int[]{-1, 0, -10, -3});
		Optional<Integer> result = cs.getMaximum();
	    assertEquals(Optional.of(0), result);			
	}

	@Test
	public void testMinOfOneItem() {
	    CalcStats cs = new CalcStats(new int[]{5});
		Optional<Integer> result = cs.getMinimum();
	    assertThat(result.get()).isEqualTo(5); //either
	    assertThat(result).contains(5);
	}
	
	@Test
	public void testEmptyArrayMinimum() {
		CalcStats cs = new CalcStats(new int[]{});
		Optional<Integer> result = cs.getMinimum();
		assertThat(result).isEmpty();
	}
	
	@Test
	public void testMinOfTwoPositiveItems() {
	    CalcStats cs = new CalcStats(new int[]{10, 2});
		Optional<Integer> result = cs.getMinimum();
	    assertEquals(Optional.of(2), result);			
	}
	
	@Test
	public void testMinOfThreePositiveMinIsTheLastElement() {
	    CalcStats cs = new CalcStats(new int[]{10, 40, 5});
		Optional<Integer> result = cs.getMinimum();
	    assertEquals(Optional.of(5), result);			
	}
}







