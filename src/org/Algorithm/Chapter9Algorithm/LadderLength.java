package org.Algorithm.Chapter9Algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ellen on 2017/6/15. 给出两个单词（start和end）和一个字典，找到从start到end的最短转换序列 比如： 每次只能改变一个字母。 变换过程中的中间单词必须在字典中出现。
 * 
 * 给出数据如下： start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"] 一个最短的变换序列是 "hit" -> "hot" -> "dot" -> "dog"
 * -> "cog"， 返回它的长度 5
 */
public class LadderLength {
	int count = 0;
	int minCount = Integer.MAX_VALUE;
    HashSet<String> list = new HashSet<>();
	public int ladderLength(String start, String end, Set<String> dict) {
		// write your code here
		if (dict.isEmpty()) {
			return 0;
		}
        change(start, end, 0, dict);
		if (minCount != Integer.MAX_VALUE) {
		    minCount += 2;
        }
		return minCount;
	}

	private void change(String start, String end, int index, Set<String> dict) {
	    if (index > start.length() || dict.isEmpty()) {
	        return;
        }
		for (int i = index; i < start.length(); i++) {
			for (String s : dict) {
				if (s.charAt(i) != start.charAt(i)) {
					int j = 0;
					for (; j < s.length(); j++) {
						if (start.charAt(j) != s.charAt(j) && i != j) {
							break;
						}
					}
                    if (j == s.length()) {
					    int temp = 0;
                        for (int k = 0; k < s.length(); k++) {
                            if (s.charAt(k) != end.charAt(k)) {
                                temp++;
                            }
                        }
                        if (temp == 1) {
                            minCount = Math.min(minCount, count);
                            System.out.println("--------" + "\t" + minCount);
                            count = 0;
                            System.out.println("list" + "\t" + list.size());
                            System.out.println("list value" + "\t" + list);
                            list.clear();
                            return;
                        }
                        list.add(s);
                        count++;
//                        System.out.println(s);
                        Set<String> set = new HashSet<>(dict);
                        set.remove(s);
                        change(s, end, 0, set);
                    }
				}
			}
		}
	}

	public static void main(String[] args) {
		LadderLength ll = new LadderLength();
		Set<String> set = new HashSet<>();
		set.add("miss");
		set.add("dusk");
		set.add("kiss");
		set.add("musk");
		set.add("tusk");
		set.add("diss");
		set.add("disk");
		set.add("sang");
		set.add("ties");
		set.add("muss");
        int i = ll.ladderLength("kiss", "tusk", set);
        System.out.println(i);
    }
}
