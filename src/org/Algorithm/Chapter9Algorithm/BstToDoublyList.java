package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.Stack;

/**
 * Created by Ellen on 2017/6/13.
 * 将一个二叉查找树按照中序遍历转换成双向链表
 */
public class BstToDoublyList {
	public DoublyListNode bstToDoublyList(TreeNode root) {
		// Write your code here
        if (root == null) {
            return null;
        }
        DoublyListNode doublyListNode = new DoublyListNode(0);
        DoublyListNode head = doublyListNode;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = stack.pop();
            DoublyListNode dn = new DoublyListNode(node.val);
            head.next = dn;
            head = dn;
            root = node.right;
        }
        return doublyListNode.next;
	}

	class DoublyListNode {
		int val;
		DoublyListNode next, prev;
		DoublyListNode(int val) {
			this.val = val;
			this.next = this.prev = null;
		}
	}
}
