package org.Algorithm.Chapter9Algorithm;

import java.util.*;

/**
 * Created by Ellen on 2017/6/13. 给定一个整型数组，找到主元素，它在数组中的出现次数严格大于数组元素个数的1/k 给出数组 [3,1,2,3,2,3,3,4,4,4] ，和 k = 3，返回 3
 */
public class MajorityNumber {
	public int majorityNumber(ArrayList<Integer> nums, int k) {
		// write your code
        HashMap<Integer, Integer> counters = new HashMap<Integer, Integer>();
        for (Integer i : nums) {
            if (!counters.containsKey(i)) {
                counters.put(i, 1);
            } else {
                counters.put(i, counters.get(i) + 1);
            }

            if (counters.size() >= k) {
                removeKey(counters);
            }
        }

        // corner case
        if (counters.size() == 0) {
            return Integer.MIN_VALUE;
        }

        // recalculate counters
        for (Integer i : counters.keySet()) {
            counters.put(i, 0);
        }
        for (Integer i : nums) {
            if (counters.containsKey(i)) {
                counters.put(i, counters.get(i) + 1);
            }
        }

        // find the max key
        int maxCounter = 0, maxKey = 0;
        for (Integer i : counters.keySet()) {
            if (counters.get(i) > maxCounter) {
                maxCounter = counters.get(i);
                maxKey = i;
            }
        }

        return maxKey;
    }

    private void removeKey(HashMap<Integer, Integer> counters) {
        Set<Integer> keySet = counters.keySet();
        List<Integer> removeList = new ArrayList<>();
        for (Integer key : keySet) {
            counters.put(key, counters.get(key) - 1);
            if (counters.get(key) == 0) {
                removeList.add(key);
            }
        }
        for (Integer key : removeList) {
            counters.remove(key);
        }
    }
}
