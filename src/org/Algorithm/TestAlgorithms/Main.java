package org.Algorithm.TestAlgorithms;

import java.util.*;

/**
 * Created by Ellen on 2017/9/2.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        class Bear {
            int fightNum;
            int hungry;

            Bear(int f, int h) {
                this.fightNum = f;
                this.hungry = h;
            }
        }
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            PriorityQueue<Integer> queue = new PriorityQueue<>(m, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            for (int i = 0; i < m; i++) {
                queue.add(sc.nextInt());
            }
            Bear[] bears = new Bear[n];
            HashMap<Bear, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                bears[i] = new Bear(sc.nextInt(), sc.nextInt());
                map.put(bears[i], i);
            }
            Arrays.sort(bears, new Comparator<Bear>() {
                @Override
                public int compare(Bear o1, Bear o2) {
                    return o2.fightNum - o1.fightNum;
                }
            });
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                while (!list.isEmpty()) {
                    queue.add(list.remove(0));
                }
                while (!queue.isEmpty()) {
                    int value = queue.peek();
                    if (bears[i].hungry >= value) {
                        bears[i].hungry = bears[i].hungry - value;
                        queue.poll();
                    } else {
                        list.add(queue.poll());
                    }
                }
            }
            int[] res = new int[n];
            for (Bear bear : map.keySet()) {
                for (int i = 0; i < n; i++) {
                    if (bear == bears[i]) {
                        res[map.get(bear)] = bears[i].hungry;
                        break;
                    }
                }
            }
            for (int i = 0; i < res.length; i++) {
                System.out.println(res[i]);
            }
        }
    }
}
