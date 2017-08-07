package org.Algorithm.InterviewAlgorithm.NowCoder;

/**
 * Created by Ellen on 2017/8/7.
 * 现在我们要读入一串数，同时要求在读入每个数的时候算出它的秩，即在当前数组中小于等于它的数的个数(不包括它自身)，
 * 请设计一个高效的数据结构和算法来实现这个功能。
 * 给定一个int数组A，同时给定它的大小n，请返回一个int数组，元素为每次加入的数的秩。保证数组大小小于等于5000。
 */
public class GetRankOfNumber {


	public int[] getRankOfNumber(int[] A, int n) {
		// write code here
		treeNode dummyNode = new treeNode(A[0]);
		treeNode head = dummyNode;
		int[] res = new int[n];
		res[0] = 0;
		for (int i = 1; i < n; i++) {
			buildTree(head, A[i]);
			res[i] = getNum(dummyNode, A[i]);
		}
		return res;
	}

	private int getNum(treeNode head, int num) {
		if (num > head.value) {
			int temp = getCount(head.left) + 1;
			while (num > head.value && head.right != null) {
				head = head.right;
				if (head.value < num) {
					temp++;
				}
				temp = temp + getCount(head.left);
			}
			return temp;
		}
		while (num < head.value && head.left != null) {
			head = head.left;
		}
		if (num == head.value) {
			return getCount(head.left);
		} else {
			return getNum(head, num);
		}
	}

	private int getCount(treeNode node) {
		if (node == null) {
			return 0;
		}
		int left = getCount(node.left);
		int right = getCount(node.right);
		return left + right + 1;
	}

	private void buildTree(treeNode head, int value) {
		treeNode node = head;
		if (value < head.value) {
			node = getNode(head, value);
		}
		if (node != null) {
			treeNode tail = new treeNode(value);
			if (value > node.value) {
				node.right = tail;
			} else if (value < node.value) {
				node.left = tail;
			}
		}
	}

	private treeNode getNode(treeNode node, int value) {
		if (node.left == null && node.right == null) {
			return node;
		}
		while (value > node.value) {
			if (node.right != null) {
				node = node.right;
			} else {
				return node;
			}
		}
		while (value < node.value) {
			if (node.left != null) {
				node = node.left;
			} else {
				return node;
			}
		}
		if (node != null) {
			return getNode(node, value);
		}
		return null;
	}

	private class treeNode {
		int value;
		public treeNode left;
		public treeNode right;

		public treeNode(int value) {
			this.value = value;
		}
	}
}
