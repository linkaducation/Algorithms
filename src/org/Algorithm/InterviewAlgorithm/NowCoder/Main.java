package org.Algorithm.InterviewAlgorithm.NowCoder;

import org.Algorithm.HelperClass.SegmentTree;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int N = in.nextInt();
            int[] scores = new int[N];
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                scores[i] = in.nextInt();
                min = Math.min(min, scores[i]);
                max = Math.max(max, scores[i]);
            }
            SegmentTree head = buildTree(min, max);
            for (int i = 0; i < N; i++) {
                addTree(head, scores[i]);
            }
            int[] res = new int[N];
            for (int i = 0; i < N; i++) {
                res[i] = getVal(head, scores[i]);
            }
            System.out.println(Arrays.toString(res));
        }
    }

    private static int getVal(SegmentTree head, int target) {
        if (target == head.max) {
            return head.val;
        }
        return getVal(head.left, target);
    }

    private static void addTree(SegmentTree head, int target) {
        if (target == head.max) {
            head.val += 1;
            return;
        }
        head.val += 1;
        if (target < head.max) {
            addTree(head.left, target);
        }
    }

    private static SegmentTree buildTree(int min, int max) {
        if (min == max) {
            return new SegmentTree(min, min, 0);
        }
        SegmentTree head = new SegmentTree(min, max, 0);
        head.left = buildTree(min, max - 1);
        return head;
    }

}

