package Challenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VirusDetector {
	/*
	 * Virus Outbreak  code gladiator
	 * 
	 *  In the Martian land faraway, a new virus has
	 * evolved and is attacking the individuals at a fast pace. The scientists have
	 * figured out the virus composition, V. The big task is to identify the people
	 * who are infected. The sample of N people is taken to check if they are
	 * POSITIVE or NEGATIVE. A report is generated which provides the current blood
	 * composition B of the person.
	 * 
	 * 
	 * POSITIVE or NEGATIVE ?
	 * 
	 * If the blood composition of the person is a subsequence of the virus
	 * composition V, then the person is identified as POSITIVE otherwise NEGATIVE.
	 * 
	 * 
	 * Example:
	 * 
	 * Virus Composition, V = coronavirus
	 * 
	 * Blood Composition of the person , B = ravus
	 * 
	 * 
	 * The person in question is POSITIVE as B is the subsequence of the V.
	 * 
	 * 
	 * 
	 * The scientists are busy with their research for medicine and request you to
	 * build a program which can quickly figure out if the person is POSITIVE or
	 * NEGATIVE. They will provide you with the virus composition V and all the
	 * people’s current blood composition. Can you help them?
	 * 
	 * 
	 * Note: The virus and blood compositions are lowercase alphabet strings.
	 * 
	 * Input Format The first line of the input consists of the virus composition, V
	 * 
	 * The second line of he input consists of the number of people, N
	 * 
	 * Next N lines each consist of the blood composition of the ith person, Bi
	 * 
	 * 
	 * 
	 * 
	 * Constraints 1<= N <=10
	 * 
	 * 1<= |B|<= |V|<= 10^5
	 * 
	 * 
	 * 
	 * Output Format For each person, print POSITIVE or NEGATIVE in a separate line
	 * 
	 * Sample
	 *  TestCase 1
	 *   Input 
	 *   coronavirus 3 
	 *   abcde 
	 *   crnas 
	 *   onarous 
	 *   Output 
	 *   NEGATIVE
	 * POSITIVE 
	 * NEGATIVE
	 */
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String stringV = scanner.nextLine();
		String stringN = scanner.nextLine();
		List<String> BList = new ArrayList<String>();
		try {
			BiPredicate<String, Integer> biPredicate = (in, maxLen) -> {
				String regex = "[a-z]*";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(in);
				return m.matches() && in.length() >= 1 && in.length() <= maxLen;
			};

			if (biPredicate.test(stringV, 100000) && Integer.parseInt(stringN) >= 1
					&& Integer.parseInt(stringN) <= 10) {
				for (int i = 0; i < Integer.parseInt(stringN); i++) {
					String Bi = scanner.nextLine();
					if (biPredicate.test(Bi, stringV.length())) {
						BList.add(Bi);
					} else {
						System.out.println("Invalid Input");
					}
				}
			} else {
				System.out.println("Invalid Input");
			}
			char[] validator = stringV.toCharArray();
			Predicate<String> predicate = t -> {
				int matchLen = 0;
				int n = 0;
				for (char c : t.toCharArray()) {
					
					for (int i = n; i < stringV.length(); i++) {
						if (c == validator[i]) {
							n = i;
							matchLen++;
							break;
						}
					}

				}
				return matchLen >= t.length();

			};
			// Validate the infection
			for (String sample : BList) {
				if (predicate.test(sample)) {
					System.out.println("POSITIVE");
				} else {
					System.out.println("NEGATIVE");
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
