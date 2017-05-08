package org.Algorithm;


import org.Algorithm.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/8.
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
    boolean result = false;

    public boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = DoesTreeHaveTree2(root1, root2);
            }
            if (!result) {
                result = hasSubtree(root1.right, root2);
            }
            if (!result) {
                result = hasSubtree(root1.left, root2);
            }
        }
        return result;
    }

    boolean DoesTreeHaveTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return false;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        if (DoesTreeHaveTree2(root1.left, root2.left) && DoesTreeHaveTree2(root1.right, root2.right)) {
            return true;
        }
        return false;
    }
}
