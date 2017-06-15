package org.Algorithm.Chapter9Algorithm;

/**
 * Created by Ellen on 2017/6/15.
 */
public class Rectangle {
    /*
    * Define two public attributes width and height of type int.
    */
    // write your code here
    public int width;
    public int hight;

    /*
         * Define a constructor which expects two parameters width and height here.
         */
    // write your code here
    public Rectangle(int width, int hight) {
        this.width = width;
        this.hight = hight;
    }

    /*
     * Define a public method `getArea` which can calculate the area of the
     * rectangle and return.
     */
    // write your code here
    public int getArea() {
        if (width != 0 && hight != 0) {
            return width * hight;
        } else {
            return 0;
        }
    }


}
