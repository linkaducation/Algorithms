package org.Algorithm.Chapter9Algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ellen on 2017/6/15.
 */
public class LadderLength2 {
    public int ladderLength2(String start, String end, Set<String> dict) {
        for (int i = 0; i < start.length(); i++) {

        }
        return 0;
    }

    private void change(String start, String end, int index, Set<String> dict) {
        if (index > start.length() || dict.isEmpty()) {
            return;
        }
        for (String s : dict) {
            if (s.charAt(index) != start.charAt(index)) {
                int i = 0;
                for (; i < start.length(); i++) {
                    if (s.charAt(i) != start.charAt(i) && i != index) {
                        break;
                    }
                }
                if (i == s.length() - 1) {

                }
            }
        }
    }
}
