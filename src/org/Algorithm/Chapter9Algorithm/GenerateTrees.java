package org.Algorithm.Chapter9Algorithm;

import org.Algorithm.SwordForOffer.HelperClass.TreeNode;

import java.util.List;

/**
 * Created by Ellen on 2017/6/16.
 * 给出n，生成所有由1...n为节点组成的不同的二叉查找树
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        byte b1 = 1, b2 = 3, b3, b6;
        final byte b4 = 4, b5 = 6;
        b6 = b4 + b5;
        System.out.println();
        return null;
    }

    public static void main(String[] args) {
        GenerateTrees gt = new GenerateTrees();
        List<TreeNode> treeNodes = gt.generateTrees(0);
    }
}
