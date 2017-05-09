package org.Algorithm;

import org.Algorithm.HelperClass.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Ellen on 2017/5/9.
 * 操作给定的二叉树，将其变换为源二叉树的镜像
 */
public class Mirror {
    List<TreeNode> left = new ArrayList<>();
    List<TreeNode> right = new ArrayList<>();
    public void mirror(TreeNode root) {
//        if (root != null) {
//            TreeNode temp = root.left;
//            root.left = root.right;
//            root.right = temp;
//            mirror(root.left);
//            mirror(root.right);
//        }
        while (root != null) {
            left.add(root.left);
            right.add(root.right);
            mirror(root.left);
            mirror(root.right);
        }
    }
}
