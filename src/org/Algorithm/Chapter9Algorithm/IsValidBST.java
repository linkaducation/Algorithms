package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/27. 给定一个二叉树，判断它是否是合法的二叉查找树(BST) 一棵BST定义为： 节点的左子树中的值要严格小于该节点的值。 节点的右子树中的值要严格大于该节点的值。
 * 左右子树也必须是二叉查找树。 一个节点的树也是二叉查找树。
 */
public class IsValidBST {
	public boolean isValidBST(TreeNode root) {
		// write your code here
        resultType v = isV(root);
        return v.flag;
    }

	public class resultType {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		Boolean flag;

		resultType(int min, int max, boolean flag) {
			this.flag = flag;
			this.min = min;
			this.max = max;
		}
	}

	private resultType isV(TreeNode root) {
		if (root == null) {
			return new resultType(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
		}
		resultType left = isV(root.left);
		resultType right = isV(root.right);

		if (!left.flag || !right.flag) {
			return new resultType(0, 0, false);
		}

		if (root.left != null && left.max >= root.val || root.right != null && right.min <= root.val) {
            return new resultType(0,0,false);
		}

		return new resultType(Math.min(root.val,left.min),Math.max(root.val,right.max),true);
	}
}
