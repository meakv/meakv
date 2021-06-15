package Challenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
/*Prime Game (100 Marks)
Rax, a school student, was bored at home in the pandemic. 
He wanted to play but there was no one to play with.
 He was doing some mathematics questions including prime numbers and thought of creating a game using the same.
  After a few days of work, he was ready with his game. He wants to play the game with you.


GAME:

Rax will randomly provide you a range [ L , R ] (both inclusive) and you have to tell him the maximum difference between the prime numbers in the given range. There are three answers possible for the given range.

There are two distinct prime numbers in the given range so the maximum difference can be found.

There is only one distinct prime number in the given range. The maximum difference in this case would be 0.

There are no prime numbers in the given range. The output for this case would be -1.


To win the game, the participant should answer the prime difference correctly for the given range.


Example:

Range: [ 1, 10 ]

The maximum difference between the prime numbers in the given range is 5.

Difference = 7 - 2 = 5


Range: [ 5, 5 ]

There is only one distinct prime number so the maximum difference would be 0.


Range: [ 8 , 10 ]

There is no prime number in the given range so the output for the given range would be -1.


Can you win the game?



Input Format
The first line of input consists of the number of test cases, T

Next T lines each consists of two space-separated integers, L and R



Constraints
1<= T <=10

2<= L<= R<=10^6



Output Format
For each test case, print the maximum difference in the given range in a separate line. 

Sample TestCase 1
Input
5
5 5
2 7
8 10
10 20
4 5
Output
0
5
-1
8
0
Explanation

Test Case 1: [ 5 - 5 ] = 0

Test Case 2: [ 7 - 2 ] = 5

Test Case 3: No prime number in the given range. Output = -1

Test Case 4: [ 19 - 11 ] = 8

Test Case 5: The difference would be 0 since there is only one prime number in the given range.
*/
public class PrimeGame {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		String stringT = scanner.nextLine();
		List<int[]> BList = new ArrayList<int[]>();
		try {
			BiPredicate<Integer, Integer> biPredicate = (in, maxLen) -> {
				return in >= 2 && in <= maxLen;
			};

			if (Integer.parseInt(stringT) >= 1
					&& Integer.parseInt(stringT) <= 10) {
				for (int i = 0; i < Integer.parseInt(stringT); i++) {
					int L = scanner.nextInt();
					int R = scanner.nextInt();
					if ((biPredicate.test(R, 1000000) && biPredicate.test(L, R))) {
						int[] ar= new int[2];
						ar[0]=L;ar[1]=R;
						BList.add(ar);
					} else {
						System.out.println("Invalid Input");
					}
					
				}
			} else {
				System.out.println("Invalid Input");
			}
			
			Predicate<Integer> isPrime=i->{
				
				if (i==2) {return true;}
				if (i==1 || i%2==0) {return false;}
				for (int j=3; j<=Math.sqrt(i);j+=2) {
					if (i%j==0) return false;
				}
				return true;
			};
			
			Function<int[],List<Integer>> fun=(t)->{
				List<Integer> ls=new ArrayList<>();
				for (int i=t[0];i<=t[1]; i++) {
					if (isPrime.test(i)) {
						ls.add(i);
						break;
					}
				}
				for (int i=t[1];i>=t[0]; i--) {
					if (isPrime.test(i)) {
						ls.add(i);
						break;
					}
				}
				return ls;
			};
	
			for (int[] array : BList) {
				List<Integer> primeList=fun.apply(array);
				int size=primeList.size();
				if (size>0) {
					System.out.println(primeList.get(size-1)-primeList.get(0));
				}else if(size==1) {System.out.println("0");} 
				else {
					System.out.println("-1");
				}
			}

		} catch (NumberFormatException nfe) {
			System.out.println("Invalid Input");
			return;
		} finally {
			scanner.close();
		}

	}

}

//}
