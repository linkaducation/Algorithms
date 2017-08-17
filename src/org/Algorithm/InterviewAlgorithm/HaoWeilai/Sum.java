package org.Algorithm.InterviewAlgorithm.HaoWeilai;

        import java.util.ArrayList;
        import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/17.
 */
public class Sum {

    private static ArrayList<String> list = new ArrayList<>();
    private static int res = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();//范围1~n
            res = in.nextInt();//和
            getCouple(n, 1, new StringBuilder(), 0);
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    private static void getCouple(int n, int index, StringBuilder sb, int sum) {
        if (sum == res) {
            list.add(sb.substring(0, sb.length() - 1));
            return;
        }
        if (index >= n - 1) {
            return;
        }
        for (int i = index; i <= n; i++) {
            StringBuilder s = new StringBuilder();
            s.append(sb.toString()).append(i + " ");
            getCouple(n, i + 1, s, sum + i);
        }
    }
}
