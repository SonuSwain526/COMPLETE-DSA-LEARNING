import java.util.*;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] grades = new int[n];

        for (int i = 0; i < n; i++) {
            grades[i] = sc.nextInt();
        }

        for (int g : grades) {

            if (g >= 38) {
                int diff = 5 - (g % 5);

                if (diff < 3) {
                    g = g + diff;
                }
            }

            System.out.println(g);
        }
    }
}