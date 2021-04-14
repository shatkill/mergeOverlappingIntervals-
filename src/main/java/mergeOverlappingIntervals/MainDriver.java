package mergeOverlappingIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import mergeOverlappingIntervals.model.Interval;

public class MainDriver {
	
	public static void main(String[] args) {
		
		// initialize input as list of intervals
		List<Interval> input = new ArrayList<Interval>();
//		input.add(new Interval(25,30));
//		input.add(new Interval(2, 19));
//		input.add(new Interval(14, 23));
//		input.add(new Interval(4, 8));
		
		input.add(new Interval(1,4));
		input.add(new Interval(7, 8));
		input.add(new Interval(5, 6));
		input.add(new Interval(3, 4));		
		
		// prints merged interval list to screen
		System.out.println(merge(input));		
	}
	
		
	public static List<Interval> merge(List<Interval> inputList) {
		
		// check if input is empty
		if(inputList.size() == 0) {
			return inputList;
		}
		
		// sorts the intervals by begin in ascending order
		Collections.sort(inputList);
		
		Stack<Interval> mergedIntervalStack = new Stack<Interval>();
				
		mergedIntervalStack.push(inputList.get(0));
		
		for(int i = 1; i < inputList.size(); i++) {
			
			/* check for overlap */
			if(mergedIntervalStack.peek().getEnd() >= inputList.get(i).getBegin()) {
				
				/* check for total overlap */
				if(mergedIntervalStack.peek().getEnd() >= inputList.get(i).getEnd()) {
					continue;
				} else {					
					Interval temp = new Interval(mergedIntervalStack.peek().getBegin(), inputList.get(i).getEnd());
					mergedIntervalStack.pop();
					mergedIntervalStack.push(temp);
				}
			} else {
				mergedIntervalStack.push(inputList.get(i));
			}
		}
				
		List<Interval> outputList = new ArrayList<Interval>();
		
		/* optional - convert result stack back to list */
		for(Interval i : mergedIntervalStack) {
			
			outputList.add(i);
		}
		
		return outputList;
	}
	
}
