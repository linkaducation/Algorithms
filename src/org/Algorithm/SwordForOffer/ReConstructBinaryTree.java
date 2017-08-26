package org.Algorithm.SwordForOffer;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/8/23.
 */
public class ReConstructBinaryTree {
    public TreeNode ReConstructBinaryTree(int[] pre, int[] in) {
        TreeNode head = buildTree(pre, in, 0, pre.length - 1, 0, in.length - 1);
        return head;
    }

    private TreeNode buildTree(int[] pre, int[] in, int pStart, int pEnd, int inStart, int inEnd) {
        if (pStart > pEnd || inStart > inEnd) {
            return null;
        }
        int inNum = pre[pStart];
        TreeNode node = new TreeNode(inNum);
        int i = 0;
        for (; i < in.length; i++) {
            if (in[i] == inNum) {
                break;
            }
        }
        node.left = buildTree(pre, in, pStart + 1, i - inStart + pStart, inStart, i - 1);
        node.right = buildTree(pre, in, pStart + i - inStart + 1, pEnd, i + 1, inEnd);
        return node;
    }
}
