package org.Algorithm;

import org.Algorithm.HelperClass.TreeNode;

import java.time.temporal.ValueRange;
import java.util.ArrayList;

/**
 * Created by Ellen on 2017/5/10.
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 */
public class PrintFromTopToBottom {
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<TreeNode> helpList = new ArrayList<>();

    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        if (root != null) {
            helpList.add(root);
        }
        while (!helpList.isEmpty()) {
            list.add(helpList.get(0).val);
            if (helpList.get(0).left != null) {
                helpList.add(helpList.get(0).left);
            }
            if (helpList.get(0).right != null) {
                helpList.add(helpList.get(0).right);
            }
            helpList.remove(0);
        }
        return list;
    }
}
