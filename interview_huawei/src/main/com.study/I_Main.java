import java.util.Scanner;

/**
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。
 */
public class I_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String source = scanner.nextLine();

        StringBuilder result = new StringBuilder();
        char[] chars = source.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            result.append(chars[i]);
        }
        System.out.println(result.toString());
    }
}
