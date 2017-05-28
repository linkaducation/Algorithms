package org.Algorithm.HelperClass;

/**
 * Created by Ellen on 2017/5/28.
 */
public class SegmentTreeNode {
	public int start, end, count;
	public SegmentTreeNode left, right;

	public SegmentTreeNode(int start, int end, int count) {
		this.start = start;
		this.end = end;
		this.count = count;
		this.left = this.right = null;
	}
}
