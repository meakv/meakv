package Challenger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortCharByFreq {
	
	/*Given a string s, sort it in decreasing order based on the frequency of characters, and return the sorted string.

			 

			Example 1:

			Input: s = "tree"
			Output: "eert"
			Explanation: 'e' appears twice while 'r' and 't' both appear once.
			So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
			Example 2:

			Input: s = "cccaaa"
			Output: "aaaccc"
			Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
			Note that "cacaca" is incorrect, as the same characters must be together.
			Example 3:

			Input: s = "Aabb"
			Output: "bbAa"
			Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
			Note that 'A' and 'a' are treated as two different characters.
			 

			Constraints:

			1 <= s.length <= 5 * 105
			s consists of English letters and digits.
			*/
	public static void main(String[] args) {
		String s = "Humsjsssdssd";

		System.out.println(frequencySort(s));

	}

	public static String frequencySort(String s) {
		char[] cArr = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		int i = 0;
		char temp = 0;
		Arrays.sort(cArr);
		for (char c : cArr) {
			if (temp != c) {
				temp = c;
				i = 0;
			}
			map.put(c, ++i);

		}
		Map<Character, Integer> map1 = map.entrySet().parallelStream()
				.sorted((i2, i1) -> i1.getValue().compareTo(i2.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		StringBuilder sb = new StringBuilder();
		for (char c : map1.keySet()) {
			int j = 0;
			while (j < map1.get(c)) {
				sb.append(c);
				j++;
			}
		}
		return sb.toString();

	}
}

//}
