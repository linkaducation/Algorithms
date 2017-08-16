package org.Algorithm.InterviewAlgorithm.netease;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/16.
 */
public class ChangeWord {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int pre = 0, pos = n - 1;
            int count = 0;
            while (pre < pos) {
                if (arr[pre] != arr[pos]) {
                    if (arr[pre] < arr[pos]) {
                        arr[pre + 1] = arr[pre] + arr[pre + 1];
                        pre++;
                    } else {
                        arr[pos - 1] = arr[pos] + arr[pos - 1];
                        pos--;
                    }
                    count++;
                } else {
                    pre++;
                    pos--;
                }
            }
            System.out.println(count);
        }
    }


}
