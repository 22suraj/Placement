import java.util.Scanner;

public class Monster {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("N = ");
        int n = sc.nextInt();
        System.out.print("M = ");
        int m = sc.nextInt();
        System.out.print("P = ");

        int[][] p = new int[n][m];
        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if(min > p[i][j]){
                    min = p[i][j];
                }
            }
            result += min;
        }

        System.out.println(result - n + 1);

    }
}
