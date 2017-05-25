package org.Algorithm.SwordForOffer;

import java.util.*;

/**
 * Created by Ellen on 2017/5/18.
 * 5 3
 * 4 2 1 10 5
 * apple
 * orange
 * mango
 * <p>
 * 7 19
 */
public class Shopping {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int sort = in.nextInt();
            int count = in.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < sort; i++) {
                list.add(in.nextInt());
            }
            Collections.sort(list);
            Set<String> organ = new HashSet<>();
            for (int i = 0; i < count; i++) {
                organ.add(in.next());
            }
            int min = 0;
            int temp = 0;
            if (count > organ.size()) {
                temp = count - organ.size();
            }
            for (int i = 0; i < organ.size(); i++) {
                min += list.get(i);
            }
            for (int i = 0; i < temp; i++) {
                min += list.get(0);
            }
            int max = 0;

            for (int i = 0; i < organ.size(); i++) {
                max += list.get(list.size() - 1 - i);
            }
            for (int i = 0; i < temp; i++) {
                max += list.get(list.size() - 1);
            }
            System.out.printf(min + " " + max + "\n");
        }
    }


}
