import java.util.Scanner;

// 十六进制转十进制
public class C_16 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            String substring = s.substring(2);
            System.out.println(Integer.parseInt(substring, 16));
        }
    }

}
