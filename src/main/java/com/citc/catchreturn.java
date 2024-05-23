package com.citc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class catchreturn {
    public static void main(String[] args) {
        System.out.println(1 + 2 + "abc" + 3 + 4);
        int a = 123;
        System.out.println(a >>> 16);

        String string = new String("a1c");
        System.out.println(string.getBytes()[1]);
        Byte b = new Byte("1");
        System.out.println(b);


        long l = 1;
        int i = (int) l;
        float f = 1.2f;
        double d = 1.2;
        double[] arr = {1, 2, 3};
        System.out.println(arr.getClass());
        System.out.println(test());
        Map map = new HashMap<String, Object>();
    }

    public static int test() {
        try {
            return 1;
        } catch (Exception e) {

        } finally {
            System.out.println("a");
        }
        return 0;
    }
}
