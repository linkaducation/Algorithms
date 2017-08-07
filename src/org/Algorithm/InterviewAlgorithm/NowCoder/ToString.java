package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/8/7.
 * 有一个非负整数，请编写一个算法，打印该整数的英文描述。
 * 给定一个int x，请返回一个string，为该整数的英文描述。
 * 测试样例：
 * 1234
 * 返回："One Thousand,Two Hundred Thirty Four"
 */
public class ToString {

	private String[] belowTen = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
	private String[] belowTwenty = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private String[] belowHundred = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};


	public String toString(int x) {
		// write code here
		if (x == 0) return "Zero";
		return helper(x);
	}

	private String helper(int num) {
		String result = "";
		if (num < 10) result = belowTen[num];
		else if (num < 20) result = belowTwenty[num - 10];
		else if (num < 100) result = belowHundred[num / 10] + " " + helper(num % 10);
		else if (num < 1000) result = helper(num / 100) + " Hundred " + helper(num % 100);
		else if (num < 1000000)
			result = helper(num / 1000) + " Thousand" + (num % 1000 > 0 ? "," : " ") + helper(num % 1000);
		else if (num < 1000000000)
			result = helper(num / 1000000) + " Million" + (num % 1000000 > 0 ? "," : " ") + helper(num % 1000000);
		else result = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
		return result.trim();
	}

	public static void main(String[] args) {
		ToString string = new ToString();
		String s = string.toString(1234);
		System.out.println(s);
	}
}
