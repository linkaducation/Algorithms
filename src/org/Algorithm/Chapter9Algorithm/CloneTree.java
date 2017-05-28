package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/28. 深度复制一个二叉树。 给定一个二叉树，返回一个他的 克隆品 。
 */
public class CloneTree {
	public TreeNode cloneTree(TreeNode root) {
		// Write your code here
        return clone(root);
	}

	public TreeNode clone(TreeNode root) {
	    if (root == null) {
	        return null;
        }
	    TreeNode node = new TreeNode(root.val);
	    node.left = clone(root.left);
	    node.right = clone(root.right);
	    return node;
    }
}
