package org.Algorithm;

/**
 * Created by Ellen on 2017/5/15.
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        char[] array = str.toCharArray();
        int len = array.length - 1;
        Reverse(array, 0, len);
        int block = 0;
        boolean flag = true;
        for (int i = 0; i <= len; i++) {
            if (' ' == (array[i])) {
                Reverse(array, block, i - 1);
                i = i + 1;
                block = i;
                flag = false;
            }
            if (i == len) {
                Reverse(array, block, i);
                flag = false;
            }
        }
        if (flag) {
            Reverse(array, 0, len);
        }
        return String.valueOf(array);
    }

    private void Reverse(char[] array, int start, int end) {
        char temp;
        while (start < end) {
            temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
    }

    public static void main(String[] args) {
        ReverseSentence rs = new ReverseSentence();
        String sentence = rs.ReverseSentence("Hello World!");
        System.out.println(sentence);
    }
}
