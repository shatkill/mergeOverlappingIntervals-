# Java Implementation of Merge Overlapping Intervals Method

## Description:
 
- took about 3h to write algorithm and tests
- built with Maven
  - dependencies: Testing Framework JUnit in version 4.13.2
- tested in Java 15
- easiest build via Eclipse IDE Git Smart Import
- time complexity   O(n*log(n))
- space complexity  O(n)             with n = amount of intervals
- Limitations: 
    - assumes that values are in the range of java long values
    - assumes that intervals are arranged with lower limit first and upper second
    - has been tested upto 10 million overlapping inputs, which runs just fine
      - higher inputs could be solved via divide and conquer approach

## Code Structure
 - MainDriver
   - merge method which takes a list of interval objects as input and merges the overlapping intervals
   - main method which calculates the readme example

 - Interval
   - POJO(Plain-Old-Java-Object) with long fields 'begin' and 'end', which provide the structure for the interval values

 - MainDriverTest
   - holds JUnit test cases

## Idea:   

- Sort intervals by begin value => potentially overlapping intervals are adjacent to each other

- put the interval of lowest begin(first in list) in the output and compare it to the remaining intervals in a loop

- determine if last output interval is overlapping the loop interval by comparing output intervals end to loop intervals begin
  - if true => check if they fully overlap by comparing both end values

    - if not fully overlap, "merge" intervals by updating outputs end value to loop intervals end and compare to next loop interval
    
  - if false => intervals don't overlap and loop interval don't has to be merged and can directly be added to the output
  - 
    - go to next loop interval and compare to newly added output interval
           
        
## Example:

- Input: [25,30] [2,19] [14, 23] [4,8]

 - Step 1: Sorting	
  
        [25,30] [2,19] [14, 23] [4,8] => [2, 19] [4, 8] [14, 23] [25, 30]        

        (in the following a = [2,19] , b = [4,8], c = [14, 23], d = [25, 30])
   
  - Step 2: Merging
    
    Iteration 1:    [2, 19] – [4,8]    
    
        => 19 > 4       => a overlaps b
        => 19 > 8       => a includes b         => push a to solution, compare to c

    Iteration 2:	[2,19] – [14, 23] 
    
        => 19 > 14      => a overlaps c                           
        => 19 < 23      => merge a and c        => update a to a' = [2, 23]

    Iteration 3:	[2, 23] – [25, 30]
    
        => 23 < 25      => a don‘t overlap d    => a‘ is fixed part of solution

    Iteration 4:	[25, 30]         
    
        => last interval                        => d is fixed part of solution

 - Output: [2, 23], [25, 30]
