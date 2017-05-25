package org.Algorithm.SwordForOffer;

import org.Algorithm.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/18. 请实现一个函数，用来判断一颗二叉树是不是对称的。 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class isSymmetrical {
	boolean isSymmetrical(TreeNode pRoot) {
		if (pRoot == null) {
			return true;
		}
		return isSymmetricals(pRoot.left, pRoot.right);
	}

	private boolean isSymmetricals(TreeNode lNode, TreeNode rNode) {
		if (lNode == null) {
			return rNode == null;
		}
		if (rNode == null) {
			return false;
		}
		return lNode.val == rNode.val && isSymmetricals(lNode.left, rNode.right)
				&& isSymmetricals(lNode.right, rNode.left);
	}
}
