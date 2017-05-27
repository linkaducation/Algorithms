package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Ellen on 2017/5/27. 二叉树前序遍历
 */
public class PreorderTraversal {
    ArrayList<Integer> list = new ArrayList<>();
	// 递归版本
	public List preorderTraversal(TreeNode root) {
		if (root == null) {
			return list;
		}
		reverse(root);
		return list;
	}

	public void reverse(TreeNode node) {
		if (node == null) {
		    return;
		}
		list.add(node.val);
		reverse(node.left);
		reverse(node.right);
	}



	//非递归版本
    public List pre(TreeNode root) {
	    if (root == null) {
	        return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
