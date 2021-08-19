public class MinCount {

    static int mincount(int[] arr, int n) {
        int result = 0;

        while (true) {
            int zerocount = 0;
            int i;
            for (i = 0; i < n; i++) {
                if (arr[i] % 2 == 1) {
                    break;
                } else if (arr[i] == 0) {
                    zerocount++;
                }
            }

            if (zerocount == n) {
                return result;
            }

            if (i == n) {
                for (int j = 0; j < n; j++) {
                    arr[j] = arr[j] / 2;
                }
                result++;
            }

            for (int j = i; j < n; j++) {
                if (arr[j] % 2 == 1) {
                    arr[j]--;
                    result++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 2, 3 };

        System.out.println("Min no. of count : " + mincount(array, array.length));
    }
}
