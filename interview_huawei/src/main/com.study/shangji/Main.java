package shangji;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例

            String wordStr = in.nextLine();
            String[] words = wordStr.split("\\,");

            int[] indexs = new int[words.length];
            StringBuilder s = new StringBuilder("");
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                word = word.trim();
                int index = wordIndex(s, word);
                if (index > 0) {
                    continue;
                }
                indexs[i] = s.length();
                s.append(word);
                s.append("#");
            }
            System.out.println(s.toString().length());
        }
    }

    public static int wordIndex(StringBuilder s, String word) {
        String dict = s.toString();
        int index = dict.indexOf(word);
        return index;
    }

    @Test
    public void test01() {
        String s = "time#";
        String s2 = "me";
        System.out.println(s.indexOf(s2));
    }

    @Test
    public void test02() {
      /*  TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                int o1Length = o1.length();
                int o2Length = o1.length();
                if (o1Length > o2Length) {
                    return 1;
                }
                if (o1Length == o2Length) {
                    return 0;
                }
                return -1;
            }
        });*/

        Collections.synchronizedList(new ArrayList<String>());


    }

}