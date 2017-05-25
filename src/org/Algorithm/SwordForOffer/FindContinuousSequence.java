package org.Algorithm.SwordForOffer;

import java.util.ArrayList;

/**
 * Created by Ellen on 2017/5/15.
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> outList = new ArrayList<>();
        if (sum == 0) {
            ArrayList<Integer> inList = new ArrayList<>();
            inList.add(0);
            outList.add(inList);
            return outList;
        }
        int first = 1, last = 2, count = 3;
        boolean flag = true;
        while (flag) {
            if (last > sum || first == last) {
                flag = false;
                return outList;
            }
            if (count < sum) {
                count += ++last;
            }
            if (count > sum) {
                count -= first;
                first++;
            }
            if (count == sum && first != last) {
                ArrayList<Integer> inList = new ArrayList<>();
                for (int i = first; i <= last; i++) {
                    inList.add(i);
                }
                outList.add(inList);
                count += ++last;
            }
        }
        return outList;
    }

    public static void main(String[] args) {
        FindContinuousSequence fs = new FindContinuousSequence();
        ArrayList<ArrayList<Integer>> arrayLists = fs.FindContinuousSequence(3);
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer integer : arrayList) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }
}
