import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 给定n个字符串，请对n个字符串按照字典序排列
 */
public class K_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nums = Integer.parseInt(scanner.nextLine());

        List<String> ret = new ArrayList<String>();
        for (int i = 0; i < nums; i++) {
            String s = scanner.nextLine();
            ret.add(s);
        }

        Collections.sort(ret);;

        for (String s : ret) {
            System.out.println(s);
        }
    }
}
