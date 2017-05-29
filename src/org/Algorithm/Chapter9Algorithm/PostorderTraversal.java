package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Ellen on 2017/5/29. 给出一棵二叉树，返回其节点值的后序遍历
 */
public class PostorderTraversal {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		// write your code here
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> saveStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            saveStack.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (!saveStack.isEmpty()) {
            result.add(saveStack.pop().val);
        }
        return result;
	}
}
