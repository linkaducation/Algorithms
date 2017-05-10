package org.Algorithm;

/**
 * Created by Ellen on 2017/5/10.
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同
 */
public class VerifySquenceOfBST {

    public boolean verifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return isSquenceOfBST(sequence, 0, sequence.length - 1);

    }

    private boolean isSquenceOfBST(int[] a, int star, int root) {
        if (star >= root)
            return true;
        int i = root;
        //从后面开始找
        while (i > star && a[i - 1] > a[root])
            i--;//找到比根小的坐标
        //从前面开始找 star到i-1应该比根小
        for (int j = star; j < i - 1; j++)
            if (a[j] > a[root])
                return false;
        ;
        return isSquenceOfBST(a, star, i - 1) && isSquenceOfBST(a, i, root - 1);
    }
}
