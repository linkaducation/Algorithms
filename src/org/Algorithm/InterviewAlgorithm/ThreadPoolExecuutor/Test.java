package org.Algorithm.InterviewAlgorithm.ThreadPoolExecuutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by Ellen on 2017/8/20.
 */
public class Test {

    public void testPrint() {
        String a = "Hello world!";
        System.out.println(a);
    }

    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 20,
                200, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<Runnable>(5));

        for (int i = 0; i < 20; i++) {
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目：" + executor.getPoolSize() + " , 队列中任务数量： " +
                    executor.getQueue().size() + ", 已执行任务数量:" + executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}

class MyTask implements Runnable {
    int num;
    Object object = new Object();

    public MyTask(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行" + num);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("任务" + num + "执行完毕");
        System.out.println();
    }
}
