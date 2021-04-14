package mergeOverlappingIntervals;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import mergeOverlappingIntervals.model.Interval;

public class MainDriverTest {
	
	
	List<Interval> input;
	List<Interval> output;
	
	@Before
	public void setUp() {
		input = new ArrayList<Interval>();
		output = new ArrayList<Interval>();
	}
	
	@Test
	public void returnEmptyListForEmptyInput() {

		assertEquals(MainDriver.merge(input).size(), 0);
	}
	
	@Test
	public void checkMergeMethodForNoOverlapOrderedInput() {
		
		input.add(new Interval(1,2));
		input.add(new Interval(3, 4));
		input.add(new Interval(5, 6));
		input.add(new Interval(7, 8));
				
		assertEquals(MainDriver.merge(input), input);
	}
	
	@Test
	public void checkMergeMethodForNoOverlapUnorederedInput() {
		
		input.add(new Interval(7, 8));
		input.add(new Interval(5, 6));
		input.add(new Interval(3, 4));
		input.add(new Interval(1, 2));
		
		output.add(new Interval(1, 2));
		output.add(new Interval(3, 4));
		output.add(new Interval(5, 6));
		output.add(new Interval(7, 8));

		assertEquals(MainDriver.merge(input), output);
	}
	
	@Test
	public void checkMergeMethodForOneOverlapUnorderedInput() {
		
		input.add(new Interval(1,4));
		input.add(new Interval(7, 8));
		input.add(new Interval(5, 6));
		input.add(new Interval(3, 4));
		
		output.add(new Interval(1,4));
		output.add(new Interval(5, 6));
		output.add(new Interval(7, 8));
				
		assertEquals(MainDriver.merge(input), output);
	}
	
	@Test
	public void checkMergeMethodForOverlapOnlyInput() {
		
		input.add(new Interval(1, 1));
		input.add(new Interval(1, 1));
		input.add(new Interval(1, 1));
		input.add(new Interval(1, 1));
		
		output.add(new Interval(1,1));
				
		assertEquals(MainDriver.merge(input), output);
	}
	
	@Test
	public void checkMergeMethodForTwoOverlapAndNegativeInput() {
		
		input.add(new Interval(-10, 5));
		input.add(new Interval(-8, 7));
		input.add(new Interval(-1, 9));
		input.add(new Interval(10, 100));
		
		output.add(new Interval(-10, 9));
		output.add(new Interval(10, 100));
				
		assertEquals(MainDriver.merge(input), output);
	}
	
	@Test
	public void checkMergeMethodForFullyOverlapInput() {
		
		input.add(new Interval(-10, 101));
		input.add(new Interval(-8, 7));
		input.add(new Interval(-1, 9));
		input.add(new Interval(10, 100));
		
		output.add(new Interval(-10, 101));
				
		assertEquals(MainDriver.merge(input), output);
	}
	
	@Test
	public void checkMergeMethodForOnlyOverlappingInputOf10MillionIntervals() {
		
		for(int i = 0; i <= 10000000; i++) {
			input.add(new Interval(9999999-i, 10000000-i));
		}
		
		output.add(new Interval(-1, 10000000));
				
		assertEquals(MainDriver.merge(input), output);
	}
	
	
}
