package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Ellen on 2017/5/28. 设计实现一个带有下列属性的二叉查找树的迭代器： 元素按照递增的顺序被访问（比如中序遍历） next()和hasNext()的询问操作要求均摊时间复杂度是O(1)
 */
public class BSTIterator {
    Queue<TreeNode> queue = new LinkedList<>();
	public BSTIterator(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tempNode = root;
        while (tempNode != null || !stack.isEmpty()) {
            while (tempNode != null) {
                stack.add(tempNode);
                tempNode = tempNode.left;
            }
            tempNode = stack.pop();
            queue.offer(tempNode);
            tempNode = tempNode.right;
        }
	}

	// @return: True if there has next node, or false
	public boolean hasNext() {
		// write your code here
        if (queue.isEmpty()) {
            return false;
        } else {
            return true;
        }
	}

	// @return: return next node
	public TreeNode next() {
		// write your code here
        TreeNode node = queue.poll();
        return node;
    }
}
