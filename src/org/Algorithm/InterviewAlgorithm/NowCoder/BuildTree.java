package org.Algorithm.InterviewAlgorithm.NowCoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Ellen on 2017/7/25.
 */
public class BuildTree {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int len = in.nextInt();
			treeNode root = new treeNode(true);
			if (len >= 2) {
				root.left = buildTree(2, len, true);
				root.right = buildTree(2, len, false);
				//深度遍历树
				treeNode head = root;
				StringBuilder s = new StringBuilder();
				List<String> res = new ArrayList<>();
				Stack<treeNode> stack = new Stack<>();
				int k = 1;
				while (!stack.isEmpty() || k <= len || head != null) {
					while (head != null) {
						stack.push(head);
						s.append(head.value == true);
						k++;
						head = head.left;
					}
					if (k == len) {
						res.add(s.toString());
					}
					head = stack.pop();
					k--;
					s = new StringBuilder(s.toString().substring(k));
					head = head.right;
				}

			} else {
				System.out.println(1);
			}
		}
	}

	private static treeNode buildTree(int level, int hight, boolean value) {
		if (level > hight) {
			return null;
		}
		treeNode node = new treeNode(value);
		node.left = buildTree(level + 1, hight, true);
		node.right = buildTree(level + 1, hight, false);
		return node;
	}

}

class treeNode {
	boolean value;
	treeNode left;
	treeNode right;

	treeNode(boolean value) {
		this.value = value;
	}
}
