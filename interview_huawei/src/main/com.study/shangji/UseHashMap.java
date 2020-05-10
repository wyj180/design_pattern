package shangji;

import java.util.HashMap;

// 演示HashMap在多线程的情况下造成死循环的情况
public class UseHashMap {

    private static HashMap<Integer, String> map = new HashMap<Integer, String>(2, 1.5f);

    public static void main(String[] args) {
        map.put(5, "C");
        map.put(7, "B");
        map.put(3, "A");

        new Thread(new Runnable() {
            public void run() {
                map.put(15, "D");
                System.out.println(map);
            }
        }, "t1").start();

        new Thread(new Runnable() {
            public void run() {
                map.put(1, "E");
                System.out.println(map);
            }
        }, "t2").start();
    }
}
