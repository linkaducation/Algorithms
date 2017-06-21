package org.Algorithm.Chapter9Algorithm;

import java.util.Scanner;

/**
 * Created by Ellen on 2017/6/21.
 * 牛牛有n张卡片排成一个序列.每张卡片一面是黑色的,另一面是白色的。
 * 初始状态的时候有些卡片是黑色朝上,有些卡片是白色朝上。牛牛现在想要把一些卡片翻过来,
 * 得到一种交替排列的形式,即每对相邻卡片的颜色都是不一样的。
 * 牛牛想知道最少需要翻转多少张卡片可以变成交替排列的形式。
 * <p>
 * 输入包括一个字符串S,字符串长度length(3 ≤ length ≤ 50),其中只包含'W'和'B'两种字符串,
 * 分别表示白色和黑色。整个字符串表示卡片序列的初始状态。
 * BBBW  1
 * 奇数偶数区分
 */
public class ChangeCard {
    public void changeCard() {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String target = in.next();
            int b = 0, w = 0;
            for (int i = 0; i < target.length(); i++) {
                if (i % 2 == 0) {
                    if (target.charAt(i) == 'W') {
                        w++;
                    }
                }
                if (i % 2 == 1) {
                    if (target.charAt(i) == 'B') {
                        w++;
                    }
                }
            }
            for (int i = 0; i < target.length(); i++) {
                if (i % 2 == 0) {
                    if (target.charAt(i) == 'B') {
                        b++;
                    }
                }
                if (i % 2 == 1) {
                    if (target.charAt(i) == 'W') {
                        b++;
                    }
                }
            }
            System.out.println(Math.min(b, w));
        }
    }

    public static void main(String[] args) {
        ChangeCard cc = new ChangeCard();
        cc.changeCard();
    }

}
