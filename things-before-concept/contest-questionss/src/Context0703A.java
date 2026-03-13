import java.util.Arrays;
import java.util.Scanner;

public class Context0703A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count =1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                count++;
                System.out.println(c + " uppercase");
            }
        }
        System.out.println(count);
    }
}
