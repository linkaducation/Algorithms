package org.Algorithm.InterviewAlgorithm.NowCoder;

public class Same {
	public boolean checkSam(String stringA, String stringB) {
		// write code here
		if (stringA.length() != stringB.length()) {
			return false;
		}
		int[] strA = new int[256];
		int[] strB = new int[256];
		for (int i = 0; i < stringA.length(); i++) {
			strA[stringA.charAt(i)]++;
		}
		for (int i = 0; i < stringB.length(); i++) {
			strB[stringB.charAt(i)]++;
		}
		for (int i = 0; i < 256; i++) {
			if (strA[i] != strB[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Same s = new Same();
		boolean world = s.checkSam("   ssssssssdfdg rfvcvfdfrgrfg r  ", " k rfvcvfdfrgrfg r ");
		System.out.println(world);
	}
}