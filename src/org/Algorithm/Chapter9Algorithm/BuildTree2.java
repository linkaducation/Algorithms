package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/29. 根据中序遍历和后序遍历树构造二叉树
 */
public class BuildTree2 {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// write your code here
		int[] npreorder = new int[preorder.length];
		int j = preorder.length - 1;
		for (int i = 0; i < preorder.length; i++, j--) {
			npreorder[i] = preorder[j];
		}
		TreeNode root = reConstructBinaryTree(preorder, 0, npreorder.length - 1, inorder, 0, inorder.length - 1);
		return root;
	}

	private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

		if (startPre < endPre || startIn > endIn) {
			return null;
		}
		TreeNode root = new TreeNode(pre[startPre]);

		for (int i = startIn; i <= endIn; i++)
			if (in[i] == pre[startPre]) {
				root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
				root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
			}

		return root;
	}
}
