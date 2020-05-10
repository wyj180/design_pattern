import java.util.Scanner;

/**
 * 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 */
public class J_Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String source = scanner.nextLine();

        StringBuilder result = new StringBuilder();

        String[] splits = source.split("\\ ");
        for (int i = splits.length - 1; i >= 0; i--) {
            result.append(splits[i]);
            if(i != 0){
                result.append(" ");
            }
        }

        System.out.println(result.toString());
    }
}
