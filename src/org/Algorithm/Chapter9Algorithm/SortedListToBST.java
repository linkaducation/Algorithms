package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.ListNode;
import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

/**
 * Created by Ellen on 2017/6/13. 给出一个所有元素以升序排序的单链表，将它转换成一棵高度平衡的二分查找树
 */
public class SortedListToBST {
    ListNode concurrt = null;
	public TreeNode sortedListToBST(ListNode head) {
		// write your code here
		// 分治法，找到中点
        concurrt = head;
        int size = getLength(head);
        return helperClass(size);
    }

	private int getLength(ListNode node) {
		int count = 0;
		while (node != null) {
            count ++;
            node = node.next;
		}
		return count;
	}

	private TreeNode helperClass (int size) {
	    if (size <= 0) {
	        return null;
        }
        TreeNode left = helperClass(size / 2);
	    TreeNode root = new TreeNode(concurrt.val);
	    concurrt = concurrt.next;
	    TreeNode right = helperClass(size - 1 - size / 2);
	    root.left = left;
	    root.right = right;
	    return root;
    }
}
