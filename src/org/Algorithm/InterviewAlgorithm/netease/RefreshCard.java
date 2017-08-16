package org.Algorithm.InterviewAlgorithm.netease;

        import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/16.
 */
public class RefreshCard {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int t = in.nextInt();
            int[][] cartd = new int[t][];
            int[] countK = new int[t];
            for (int i = 0; i < t; i++) {
                int n = in.nextInt();
                countK[i] = in.nextInt();
                cartd[i] = new int[2 * n];
                for (int j = 0; j < 2 * n; j++) {
                    cartd[i][j] = in.nextInt();
                }
            }
            for (int i = 0; i < t; i++) {
                int[] ints = reCartd(cartd[i], countK[i], 0);
                System.out.print(ints[0]);
                for (int j = 1; j < ints.length; j++) {
                    System.out.print(" " + ints[j]);
                }
                System.out.println();
            }

        }
    }

    private static int[] reCartd(int[] cards, int count, int index) {
        if (index >= count) {
            return cards;
        }
        int[] temp = new int[cards.length];
        int len = cards.length;
        for (int i = 0, k = len - 1; i < len / 2; ) {
            temp[k] = cards[len - i - 1];
            temp[k - 1] = cards[len / 2 - 1 - i];
            i += 1;
            k -= 2;
        }
        return reCartd(temp, count, index + 1);
    }
}
