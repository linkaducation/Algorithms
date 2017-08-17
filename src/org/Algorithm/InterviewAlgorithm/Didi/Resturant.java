package org.Algorithm.InterviewAlgorithm.Didi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Ellen on 2017/8/17.
 */
public class Resturant {
    static class guest {
        int people;
        int fee;

        guest() {

        }

        guest(int people, int fee) {
            this.people = people;
            this.fee = fee;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int n = in.nextInt();//n张桌子
            int m = in.nextInt();//m批客人
            int[] desk = new int[n];
            for (int i = 0; i < n; i++) {
                desk[i] = in.nextInt();//每张桌子容纳的人数
            }
            guest[] gueste = new guest[m];
            for (int i = 0; i < m; i++) {
                gueste[i] = new guest();
                gueste[i].people = in.nextInt();//第i批客人的人数及预计消费金额
                gueste[i].fee = in.nextInt();
            }
            Arrays.sort(gueste, new Comparator<guest>() {
                @Override
                public int compare(guest o1, guest o2) {
                    return o1.people - o2.people;
                }
            });
            Arrays.sort(desk);
            boolean[] isEating = new boolean[m];//客人是否已经在吃饭
            Arrays.fill(isEating, false);
            int count = 0;
            for (int i = 0; i < n; i++) {
                int size = desk[i];
                int index = getGuest(size, gueste, isEating);
                if (index != -1) {
                    count += gueste[index].fee;
                    isEating[index] = true;
                }
            }
//            System.out.println(Arrays.toString(isEating));
            System.out.println(count);
        }
    }

    private static int getGuest(int size, guest[] guests, boolean[] isEating) {
        int i = 0;
        for (; i < guests.length; i++) {
            if (guests[i].people > size) {
                int res = -1;
                int max = Integer.MIN_VALUE;
                for (int j = 0; j < i; j++) {
                    if (guests[j].fee > max && !isEating[j]) {
                        max = guests[j].fee;
                        res = j;
                    }
                }
                return res;
            }
        }
        return -1;
    }
}
