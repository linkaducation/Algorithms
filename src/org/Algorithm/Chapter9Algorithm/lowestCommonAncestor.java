package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/27. 给定一棵二叉树，找到两个节点的最近公共父节点(LCA)。 最近公共祖先是两个节点的公共的祖先节点且具有最大深度。 假设给出的两个节点都在树中存在
 */
public class lowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		// write your code here
        TreeNode node = getAncester(root, A, B);
        return node;
    }

	private TreeNode getAncester(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B) {
            return root;
        }
        TreeNode left = getAncester(root.left, A, B);
        TreeNode right = getAncester(root.right, A, B);

        if (left != null && right != null) {
            return root;
        }
        if (right != null) {
            return right;
        }
        if (left != null) {
            return left;
        }
        return null;
    }
}
