package org.Algorithm;

import org.Algorithm.HelperClass.TreeLinkNode;

/**
 * Created by Ellen on 2017/5/18.
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * <p>
 * 1.如果空节点，返回null
 * 2.如果不为空
 * 2.1 如果是根节点，且右孩子存在，寻找又孩子的最左节点
 * 2.2 如果是左孩子节点，返回父节点
 * 2.3 如果是右孩子节点，即重复2.1
 */
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.next == null) {
            if (pNode.right != null) {
                return findChild(pNode.right);
            } else {
                return pNode;
            }
        } else if (pNode == pNode.next.left) {
            if (pNode.right != null) {
                return findChild(pNode.right);
            } else {
                return pNode.next;
            }
        } else if (pNode == pNode.next.right){
            if (pNode.right != null) {
                return findChild(pNode.right);
            } else {
                return pNode.next;
            }
        }
        return pNode;
    }

    private TreeLinkNode findChild(TreeLinkNode pNode) {
        if (pNode.left != null) {
            return findChild(pNode.left);
        } else
            return pNode;
    }
}
