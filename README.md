# Java Implementation of Merge Overlapping Intervals Method


Idea:   

    Sort intervals by begin value => potentially overlapping intervals are adjacent to each other

    Put first interval on stack, loop through remaining intervals in ascending order
    
        check if end of stack top interval overlaps start of loop interval
        
            if yes check if loop interval has greater end value than stack top interval
            
                if yes set stack top end value to loop interval end value = merge
                
            if no overlap loop interval can be added to stack
           
        
Example:

    Input: [25,30] [2,19] [14, 23] [4,8]

    Sorting:	[25,30] [2,19] [14, 23] [4,8] => [2, 19] [4, 8] [14, 23] [25, 30]        
    
    (in the following a = [2,19] , b = [4,8], c = [14, 23], d = [25, 30])

    Merging:
    
    Iteration1: 	[2, 19] – [4,8]    
    
            => 19 > 4		=> a overlaps b
            => 19 > 8 		=> a includes b		=> push a to solution, compare to c

    Iteration2:	[2,19] – [14, 23] 
    
            => 19 > 14	=> a overlaps c                           
            => 19 < 23	=> merge a and c 		=> update a to a' = [2, 23]

    Iteration3:	[2, 23] – [25, 30]
    
            => 23 < 25	=> a don‘t overlap d 	=> a‘ is fixed part of solution

    Iteration4:	[25, 30]         
    
            => last interval				=> d is fixed part of solution

    Output: [2, 23], [25, 30]
