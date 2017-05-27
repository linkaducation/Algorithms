package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/5/27.
 */
public class SingleInstance {
	private SingleInstance() {
    }
    private static SingleInstance singleInstance;
    public static synchronized SingleInstance getInstance() {
        if (singleInstance == null){
            singleInstance = new SingleInstance();
            return singleInstance;
        } else {
            return singleInstance;
        }
    }

    public static void main(String[] args) {
        SingleInstance instance = getInstance();
        SingleInstance instance2 = getInstance();
        SingleInstance instance3 = getInstance();
        System.out.println(instance == instance2);
    }
}
