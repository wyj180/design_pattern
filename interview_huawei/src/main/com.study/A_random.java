import org.junit.Test;

import java.util.Scanner;
import java.util.TreeSet;

public class A_random {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt(); // 输入随机数的个数
            TreeSet<Integer> set = new TreeSet<Integer>();
            for (int i = 0; i < num; i++) {
                int curr = sc.nextInt(); // n个随机整数组成的数组
                set.add(curr);
            }
            for (Integer i : set) {
                System.out.println(i);
            }
        }
        sc.close();
    }

    // treeMap源码分析参考博客：https://www.jianshu.com/p/3b5e2677935d
    // 测试使用TreeSet(默认排序为1,2,3,4,5)
    // TreeSet是一个有序的集合，基于TreeMap实现，支持两种排序方式：自然排序和定制排序。
    // TreeSet是非同步的，线程不安全的。
    @Test
    public void test01() {
        TreeSet<Integer> set = new TreeSet<Integer>(); // 正序排序; 会输出: 1,2,3,4,5

        // 倒序排序：会输出 5 4 3 2 1
        /*TreeSet<Integer> set = new TreeSet<Integer>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });*/
        set.add(5);
        set.add(3);
        set.add(2);
        set.add(1);
        set.add(4);
        for (Integer i : set) {
            System.out.println(i);
        }
    }
}
