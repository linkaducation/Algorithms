package org.Algorithm.InterviewAlgorithm.netease;


import java.util.*;

/**
 * Created by Ellen on 2017/8/15.
 */
public class EatShell {
    private static int res = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int pos = in.nextInt();
            Queue<Long> queue = new LinkedList<>();
            Map<Long, Integer> map = new HashMap<>();
            map.put((long) pos, 1);
            queue.offer((long) pos);
            int time = -1;
            while (!queue.isEmpty()) {
                Long n = queue.poll();
                if (n == 0) {
                    time = map.get(n) - 1;
                    break;
                }
                if (map.get(n) >= 100001) {
                    continue;
                }
                if (!map.containsKey((4 * n + 3) % 1000000007)) {
                    map.put((4 * n + 3) % 1000000007, map.get(n) + 1);
                    queue.offer((4 * n + 3) % 1000000007);
                }
                if (!map.containsKey((8 * n + 7) % 1000000007)) {
                    map.put((8 * n + 7) % 1000000007, map.get(n) + 1);
                    queue.offer((8 * n + 7) % 1000000007);
                }
            }
            System.out.println(time);
        }
    }

}
