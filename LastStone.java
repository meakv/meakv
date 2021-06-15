package Challenger;

import java.util.Arrays;
/*
We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)

 

Example 1:

Input: [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 

Note:

1 <= stones.length <= 30
1 <= stones[i] <= 1000
*/
public class LastStone {
public static void main(String[] args) {
	int[] ds= {3,2};
System.out.println(lastStoneWeight(ds));	

	
}
public static int [] todphod(int[] stones){
	Arrays.sort(stones);
	int length=stones.length;
	//if both stones of equal wt ,both ll become 0 
	if (stones[length-1]==stones[length-2]) {
		int[] copy= new int[length-2];
		 System.arraycopy(stones, 0, copy, 0, length-2);
		 return copy;
	}
	else {
		//if both stones of unequal wt ,result will be the diff 
		int[] copy= new int[length-1];
		 System.arraycopy(stones, 0, copy, 0, length-2);
		 copy[copy.length-1]=stones[length-1]-stones[length-2];
		 return copy;
	}
}

public static int lastStoneWeight(int[] stones) {
	if (stones.length==1) {
		return stones[0];
	}else if (stones.length==2) {
		return Math.abs(stones[1]-stones[0]);
	}
	
	return lastStoneWeight(todphod(stones));
    
}
}
