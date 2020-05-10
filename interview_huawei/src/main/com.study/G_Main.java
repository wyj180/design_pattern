import java.util.Scanner;
import java.util.TreeSet;

/**
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 */
public class G_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String source = scanner.nextLine();

        StringBuilder s = new StringBuilder();

        TreeSet<Character> set = new TreeSet();
        char[] chars = source.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (!set.contains(chars[i])) {
                s.append(chars[i]);
            }
            set.add(chars[i]);
        }
        System.out.println(Integer.parseInt(s.toString()));
    }
}
