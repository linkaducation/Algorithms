package org.Algorithm.Chapter9Algorithm;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ellen on 2017/6/17.
 * 设计一个算法，找出只含素因子2，3，5 的第 n 大的数。
 * 符合条件的数如：1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        // Write your code here
        List<Integer> uglys = new ArrayList<Integer>();
        uglys.add(1);

        int p2 = 0, p3 = 0, p5 = 0;
        // p2, p3 & p5 share the same queue: uglys

        for (int i = 1; i < n; i++) {
            int lastNumber = uglys.get(i - 1);
            while (uglys.get(p2) * 2 <= lastNumber) p2++;
            while (uglys.get(p3) * 3 <= lastNumber) p3++;
            while (uglys.get(p5) * 5 <= lastNumber) p5++;

            uglys.add(Math.min(
                    Math.min(uglys.get(p2) * 2, uglys.get(p3) * 3),
                    uglys.get(p5) * 5
            ));
        }
        System.out.println(Arrays.toString(uglys.toArray()));
        return uglys.get(n - 1);
    }


    public static void main(String[] args) {
        try {
            RandomAccessFile raf = new RandomAccessFile("H:/你好.txt","rw");
            RandomAccessFile raf2 = new RandomAccessFile("H:/1.txt","rw");
            FileChannel channel = raf.getChannel();
            FileChannel channel2 = raf2.getChannel();

            ByteBuffer bb = ByteBuffer.allocate(1024);
            CharBuffer bb2 = CharBuffer.allocate(1024);

            int bytesRead = channel.read(bb);

            while (bytesRead != -1) {
                System.out.println("Read " + bytesRead);
                bb.flip();
                bb2.put((char)bb.get());
                while (bb.hasRemaining()) {
                    System.out.println((char) bb.get());

                }
                bb.clear();
                bytesRead = channel.read(bb);
            }

            raf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
