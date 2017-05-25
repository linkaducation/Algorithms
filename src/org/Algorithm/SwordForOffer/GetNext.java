package org.Algorithm.SwordForOffer;

import org.Algorithm.HelperClass.TreeLinkNode;

/**
 * Created by Ellen on 2017/5/18. 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * <p>
 * 1.如果空节点，返回null 2.如果不为空 2.1 如果是根节点，且右孩子存在，寻找又孩子的最左节点 2.2 如果是左孩子节点，返回父节点 2.3 如果是右孩子节点，即重复2.1
 */
public class GetNext {
	public TreeLinkNode GetNext(TreeLinkNode pNode) {
		if (pNode == null) {
			return null;
		}
		if (pNode.right != null) {
		    pNode = pNode.right;
		    while (pNode.left != null) {
		        pNode = pNode.left;
            }
            return pNode;
		}
		while (pNode.next != null) {
		    if (pNode.next.left == pNode) {
		        return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
	}
}
