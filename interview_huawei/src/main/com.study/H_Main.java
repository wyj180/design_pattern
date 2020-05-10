import java.util.Scanner;

/**
 * 输入一个整数，将这个整数以字符串的形式逆序输出
 * 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 */
public class H_Main {

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
