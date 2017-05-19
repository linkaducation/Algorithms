package org.Algorithm;

import org.Algorithm.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/18.
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class isSymmetrical {
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return false;
        }
        return isSymmetricals(pRoot.left, pRoot.right);
    }

    private boolean isSymmetricals(TreeNode lNode, TreeNode rNode) {
        if (lNode == null && rNode == null) {
            return true;
        }
        if ((lNode != null && rNode == null) || (lNode == null && rNode != null)) {
            return false;
        }
        if (lNode != rNode) {
            return false;
        }
        return isSymmetricals(lNode.left, rNode.left) && isSymmetricals(lNode.right, rNode.right);
    }
}
