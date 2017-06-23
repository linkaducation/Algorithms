package org.Algorithm.InterviewAlgorithm.NowCoder;

		import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/23.
 */
public class DNAadapt {

	public static void main(String[] args) {
		Scanner	in = new Scanner(System.in);
		while (in.hasNext()) {
			String s1 = in.next();
			String s2 = in.next();
			int min = 0;
			for (int i = 0; i < s1.length(); i++) {
				if (!isOK(s1.charAt(i), s2.charAt(i))) {
					min++;
				}
			}
//			int min2 = 0;
//			for (int i = 0; i < s1.length(); i++) {
//				if (!isOK(s1.charAt(i), s1.charAt(s2.length() - i - 1))) {
//					min2++;
//				}
//			}
//			System.out.println(Math.min(min, min2));
			System.out.println(min);
		}
	}

	private static boolean isOK(char s1, char s2) {
		if (s1 == 'A' && s2 == 'T' || s1 == 'T' && s2 == 'A'
				|| s1 == 'C' && s2 == 'G' || s1 == 'G' && s2 == 'C') {
			return true;
		}
		return false;
	}
}
