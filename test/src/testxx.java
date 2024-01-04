import static java.lang.Character.getType;

/**
 * @author ChanceZhou
 * @code this file2022-01-23-21:35
 */
public class testxx {
    public static void main(String[] args) {
//        short s = 3;
////        s = s + 2;
//        s += 2;
//
//        int i = 1;
//        i *= 0.1;
//        System.out.println(i);//
//        i++;
//        System.out.println(i);
//        int m = 2;
//        int n = 3;
//        n *= m++;
//        System.out.println("m=" + m);
//        System.out.println("n=" + n);

//        int n = 10;
//        n += (n++) + (++n);
        /**
         * 优先级
         * ++ > + > +=
         *
         * (n++) 此时n还是10  等一下变11①
         * (++n) n=11②
         * (n++) + (++n) = 10+11=21③
         * n += (n++) + (++n) n= ①n=11 + ③21 = 32
         * n=32
         **/
//        System.out.println(n);

/*
        boolean x = true;
        boolean y = false;
        short z = 42;
        //if(y == true)
        if ((z++ == 42) && (y = true)) z++;
        System.out.println(z);//44 判断为true +1 , if里面的z++ +1
        if ((x = false) || (++z == 45)) z++;
        //判断为true +1 , if里面的z++ +1
        System.out.println("z =" + z);//46
 */


//        boolean x = true;
//        boolean y = false;
//        short z = 42;
//        if(y == true)
//            if ((z++ == 42) && (y = true)) z++;
//        System.out.println(z);//42
//        if ((x = false) || (++z == 45)) z++;
//        System.out.println("z =" + z);//43

//        int[] arr = new int[10];
//        System.out.println(arr);//地址值?地址值
//
//        System.out.println("*********************");
////        System.out.println(arr[0]);
//        char[] arr1 = new char[10];
////        for (char c : arr1) {
////            System.out.println(c);
////        }
//// 空字符
//        System.out.println("**");
//
//        System.out.println(arr1); //地址值?空字符
//        System.out.println("**");

//    test();
/*
        Object o1 = true ? new Integer(1) : new Double(2.0);
        System.out.println(o1);
        Object o2;
        if (true)
            o2 = new Integer(1);
        else
            o2 = new Double(2.0);
        System.out.println(o2);//
        */

        method1();
    }

    public static void test() {
        char[] arr = new char[]{'a', 'b', 'c'};
        System.out.println(arr);//abc
        int[] arr1 = new int[]{1, 2, 3};
        System.out.println(arr1);//地址
        double[] arr2 = new double[]{1.1, 2.2, 3.3};
        System.out.println(arr2);//地址
    }

    public static void method1() {
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);
        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);//
        Integer x = 128;
        Integer y = 128;
        System.out.println(x == y);//
    }
}
