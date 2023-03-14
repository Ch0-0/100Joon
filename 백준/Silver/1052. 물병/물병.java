import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int rst = buyBottle(N, K);
        System.out.println(rst);
        br.close();
    }

    private static int buyBottle(int n, int k) {

        if(n <= k) return 0;

        for (int loop = 0; loop < k - 1; loop++) {
            int base = 0;
            while (Math.pow(2, base) < n) {
                base++;
            }
            n -= Math.pow(2, base - 1);

            if(n == 0) return 0;
        }

        int base = 0;
        while (Math.pow(2, base) < n) {
            base++;
        }
        return (int) Math.pow(2, base) - n;
    }
}