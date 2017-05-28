package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/28.
 * 反转二叉树
 */
public class InvertBinaryTree {
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        invert(root);
    }

    private void invert(TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode left = null;
        TreeNode right = null;
        if (node.left != null) {
            left = node.left;
        }
        if (node.right != null) {
            right = node.right;
        }
        node.left = right;
        node.right = left;
        invert(node.left);
        invert(node.right);
    }
}
