package org.Algorithm.SwordForOffer;


import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/11.
 */
public class ConverSub {
    TreeNode head = null;
    TreeNode realHead = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        ConvertSub(pRootOfTree);
        return realHead;
    }

    private void ConvertSub(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return;
        ConvertSub(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
            realHead = pRootOfTree;
        } else {
            head.right = pRootOfTree;
            pRootOfTree.left = head;
            head = pRootOfTree;
        }
        ConvertSub(pRootOfTree.right);
    }
}
