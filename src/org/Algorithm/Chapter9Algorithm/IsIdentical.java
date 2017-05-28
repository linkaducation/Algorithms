package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/28. 检查两棵二叉树是否等价。等价的意思是说，首先两棵二叉树必须拥有相同的结构，并且每个对应位置上的节点上的数都相等。
 */
public class IsIdentical {
	public boolean isIdentical(TreeNode a, TreeNode b) {
		// Write your code here
        return isEq(a, b);
    }

	public boolean isEq(TreeNode a, TreeNode b) {
		if (a == null || b == null) {
		    if (a == null && b == null) {
		        return true;
            } else {
		        return false;
            }
        }

		if (a.val != b.val) {
		    return false;
        }

		boolean left = isEq(a.left, b.left);
		boolean right = isEq(a.right, b.right);

		return left && right;
	}

    public static void main(String[] args) {
        TreeNode node = null;
        System.out.println(node == null);
    }
}
