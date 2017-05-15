package org.Algorithm;

import org.Algorithm.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/15.
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度
 */
public class TreeDepth {
    private int leftDeep = 1;
    private int rightDeep = 1;

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            leftDeep++;
            hasChild(root.left);
        }
        if (root.right != null) {
            rightDeep++;
            hasChild(root.right);
        }
        return leftDeep > rightDeep ? leftDeep : rightDeep;
    }

    private void hasChild(TreeNode root) {
        if (root.left != null) {
            leftDeep++;
            hasChild(root.left);
        }
        if (root.right != null) {
            rightDeep++;
            hasChild(root.right);
        }
    }
}
