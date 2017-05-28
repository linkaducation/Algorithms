package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;
import sun.security.util.Length;

/**
 * Created by Ellen on 2017/5/28. 根据前序遍历和中序遍历树构造二叉树.
 */
public class BuildTree {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		// write your code here
		TreeNode root = reConstructBinaryTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
		return root;
	}

	private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

		if (startPre > endPre || startIn > endIn) {
            return null;
        }
		TreeNode root = new TreeNode(pre[startPre]);

		for (int i = startIn; i <= endIn; i++)
			if (in[i] == pre[startPre]) {
				root.left = reConstructBinaryTree(pre, startPre + 1,
                        startPre + i - startIn, in, startIn, i - 1);
				root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1,
                        endPre, in, i + 1, endIn);
			}

		return root;
	}

    public static void main(String[] args) {
        BuildTree bt = new BuildTree();
        TreeNode tree = bt.buildTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
        System.out.println(tree.val);
//        String s = "12344";
//        char c = s.charAt(0);
//        String s1 = String.valueOf(c);
//        System.out.println(Integer.valueOf(s1));
    }
}
