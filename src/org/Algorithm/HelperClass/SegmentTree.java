package org.Algorithm.HelperClass;

/**
 * Created by Ellen on 2017/8/26.
 * 线段树
 */
public class SegmentTree {
    public int min;
    public int max;
    public int val;
    public SegmentTree left;
    public SegmentTree right;

    public SegmentTree(int min, int max, int val) {
        this.min = min;
        this.max = max;
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
