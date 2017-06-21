package org.Algorithm.Chapter9Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/21.
 * 牛家庄幼儿园为庆祝61儿童节举办庆祝活动,庆祝活动中有一个节目是小朋友们围成一个圆圈跳舞。
 * 牛老师挑选出n个小朋友参与跳舞节目,已知每个小朋友的身高h_i。为了让舞蹈看起来和谐,
 * 牛老师需要让跳舞的圆圈队形中相邻小朋友的身高差的最大值最小,牛老师犯了难,希望你能帮帮他。
 * 如样例所示:
 * 当圆圈队伍按照100,98,103,105顺时针排列的时候最大身高差为5,其他排列不会得到更优的解
 */
public class GetMin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < n; i++) {
                list.add(arr[i]);
            }
            int[] res = new int[n];
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (flag) {
                    res[i] = list.get(list.size() / 2 - 1);
                    list.remove(list.size() / 2 - 1);
                    flag = false;
                } else {
                    res[i] = list.get(0);
                    list.remove(0);
                    flag = true;
                }
            }
            int min = Integer.MIN_VALUE;
            for (int i = 1; i < res.length; i++) {
                min = Math.max(min, res[i] - res[i - 1]);
            }
//            System.out.println(Arrays.toString(res));
            System.out.println(min);
        }
    }
}
