package org.Algorithm.InterviewAlgorithm.HaoWeilai;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/17.
 */
public class NminNum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String num = in.nextLine();
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            String[] arr =  num.split(" ");
            int n = Integer.valueOf(arr[arr.length - 1]);
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].charAt(0) == '-') {
                    int tem = Integer.valueOf(arr[i].substring(1, arr[i].length()));
                    queue.add(-tem);
                } else {
                    int tem = Integer.valueOf(arr[i]);
                    queue.add(tem);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n - 1; i++) {
                sb.append(queue.poll() + " ");
            }
            sb.append(queue.poll());
            System.out.println(sb.toString());
        }
    }
}
