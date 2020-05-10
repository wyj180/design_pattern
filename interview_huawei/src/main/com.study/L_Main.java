import java.util.Scanner;

/**
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 */
public class L_Main {

    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        int n = str.nextInt();
        String se = Integer.toBinaryString(n);
        char[] ch = se.toCharArray();
        int count = 0;
        for (int i = 0; i < se.length(); i++) {
            if (ch[i] == '1') {
                count++;
            }
        }
        System.out.println(count);
    }
}
