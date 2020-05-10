import java.util.Scanner;
import java.util.TreeMap;

/**
 * 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，
 * 即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
 */
public class F_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        // 使用有序的TreeMap
        TreeMap<Integer, Integer> treeMap = new TreeMap<Integer, Integer>();

        //String inputKV2 = scanner.nextLine();
        //System.out.println(inputKV2);

        for (int i = 0; i < num; i++) {
            String inputKV = scanner.nextLine();

            String[] kv = inputKV.split("\\ ");
            Integer key = Integer.parseInt(kv[0]);
            Integer value = Integer.parseInt(kv[1]);

            if (treeMap.containsKey(key)) {
                treeMap.put(key, treeMap.get(key) + value);
            } else {
                treeMap.put(key, value);
            }
        }

        // 打印结果
        for (Integer key : treeMap.keySet()) {
            System.out.println(key + " " + treeMap.get(key));
        }
    }
}
