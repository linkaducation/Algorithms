package org.Algorithm.SwordForOffer;

import java.util.ArrayList;

import org.Algorithm.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/5/25. 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
 */
public class PrintTree {
	ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		ArrayList<ArrayList<Integer>> outside = new ArrayList<ArrayList<Integer>>();
		ArrayList<TreeNode> arr1 = new ArrayList<>();
		ArrayList<TreeNode> arr2 = new ArrayList<>();
		if (pRoot == null) {
		    return outside;
        }
		arr1.add(pRoot);
		while (true) {
			ArrayList<Integer> temp = new ArrayList<>();
			if (!arr1.isEmpty()) {
				while (!arr1.isEmpty()) {
					pRoot = arr1.get(0);
					if (pRoot.left != null) {
						arr2.add(pRoot.left);
					}
					if (pRoot.right != null) {
						arr2.add(pRoot.right);
					}
					temp.add(pRoot.val);
					arr1.remove(0);
				}
				outside.add(temp);
				continue;
			}
			if (!arr2.isEmpty()) {
				while (!arr2.isEmpty()) {
					pRoot = arr2.get(0);
					if (pRoot.left != null) {
						arr1.add(pRoot.left);
					}
					if (pRoot.right != null) {
						arr1.add(pRoot.right);
					}
					temp.add(pRoot.val);
					arr2.remove(0);
				}
				outside.add(temp);
				continue;
			}
			break;
		}
		return outside;
	}

    public static void main(String[] args) {
        PrintTree pt = new PrintTree();
        ArrayList<ArrayList<Integer>> t = pt.Print(null);
        System.out.println(t);
    }
}
