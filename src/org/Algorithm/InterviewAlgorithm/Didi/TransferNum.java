package org.Algorithm.InterviewAlgorithm.Didi;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/17.
 */
public class TransferNum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            int tempCoun = 1;
            int t = Math.abs(m);
            while (tempCoun < t) {
                tempCoun *= n;
                list.add(tempCoun);
            }
            StringBuilder sb = new StringBuilder();
            if (m < 0) {
                sb.append("-");
            }
            if (list.get(list.size() - 1) > t) {
                list.remove(list.size() - 1);
            }
            String[] dic = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                    "A", "B", "C", "D", "E", "F", "G"};
            for (int i = list.size() - 1; i >= 0; i--) {
                int temp = list.get(i);
                if (temp <= t) {
                    int tem = t / temp;
                    sb.append(dic[tem]);
                    t -= temp * tem;
                } else {
                    sb.append(0);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
