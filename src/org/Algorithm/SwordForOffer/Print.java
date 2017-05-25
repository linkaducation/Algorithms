package org.Algorithm.SwordForOffer;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.ArrayList;
import java.util.Stack;


/**
 * Created by Ellen on 2017/5/25. 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Print {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
		// flag为true时正方向，glag为false时为逆方向
		boolean flag = true;
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		stack2.push(pRoot);
		while (pRoot != null) {
			ArrayList<Integer> temp = new ArrayList<>();
			if (flag) {
				while (!stack2.isEmpty()) {
					pRoot = stack2.pop();
                    if (pRoot.left != null) {
                        stack1.push(pRoot.left);
                    }
                    if (pRoot.right != null) {
                        stack1.push(pRoot.right);
                    }
					temp.add(pRoot.val);
				}
				list.add(temp);
				flag = false;
                if (!stack1.isEmpty()) {
                    pRoot = stack1.peek();
                } else {
                    pRoot = null;
                }
			} else {
				while (!stack1.isEmpty()) {
				    pRoot = stack1.pop();
                    if (pRoot.right != null) {
                        stack2.push(pRoot.right);
                    }
                    if (pRoot.left != null) {
                        stack2.push(pRoot.left);
                    }
					temp.add(pRoot.val);
				}
				list.add(temp);
				flag = true;
				if (!stack2.isEmpty()) {
                    pRoot = stack2.peek();
                } else {
				    pRoot = null;
                }
			}
		}
		return list;
	}
}
