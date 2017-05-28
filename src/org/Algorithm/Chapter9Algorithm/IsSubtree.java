package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Ellen on 2017/5/28. 有两个不同大小的二进制树： T1 有上百万的节点； T2 有好几百的节点。请设计一种算法，判定 T2 是否为 T1的子树。
 */
public class IsSubtree {
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T2 == null) {
            return true;
        }
        if (T1 == null) {
            return false;
        }

        if (isEqual(T1, T2)) {
            return true;
        }
        if (isSubtree(T1.left, T2) || isSubtree(T1.right, T2)) {
            return true;
        }
        return false;
    }

    private boolean isEqual(TreeNode T1, TreeNode T2) {
        if (T1 == null || T2 == null) {
            return T1 == T2;
        }
        if (T1.val != T2.val) {
            return false;
        }
        return isEqual(T1.left, T2.left) && isEqual(T1.right, T2.right);
    }

	public static void main(String[] args) {
		TreeNode root1 = new TreeNode(1);
		TreeNode root2 = new TreeNode(2);
		TreeNode root3 = new TreeNode(3);
		TreeNode root4 = new TreeNode(4);
		TreeNode root5 = new TreeNode(3);
		TreeNode root6 = new TreeNode(4);
		root1.left = root2;
		root1.right = root3;
		root3.left = root4;
		root5.right = root6;
		IsSubtree is = new IsSubtree();

	}
}
