package org.Algorithm.SwordForOffer;

import org.Algorithm.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/25. 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class SerializeTree {
	int index = -1;

	String Serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			return sb.append("$,").toString();
		}
		sb.append(root.val + ",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
	}

	TreeNode Deserialize(String str) {
		index++;
		String[] array = str.split(",");
		int len = array.length;
		TreeNode node = null;
		if (!array[index].equals("$")) {
			node = new TreeNode(Integer.valueOf(array[index]));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		return node;
	}
}
