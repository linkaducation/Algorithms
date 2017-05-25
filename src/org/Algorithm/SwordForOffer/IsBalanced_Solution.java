package org.Algorithm.SwordForOffer;

import org.Algorithm.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/15.
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树
 */
public class IsBalanced_Solution {
    private boolean isBalance = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return isBalance;
        }
        isBalance(root);
        return isBalance;
    }

    private int isBalance(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = isBalance(root.left);
        int right = isBalance(root.right);
        if (Math.abs((right - left)) > 1) {
            isBalance = false;
            return 0;
        }
        return right > left ? right + 1 : left + 1;
    }
}
