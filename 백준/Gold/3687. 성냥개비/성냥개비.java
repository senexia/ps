import java.io.*;
import java.util.*;

public class Main {

    static String greedy(int n) {
        StringBuilder ret = new StringBuilder();
        if (n % 2 == 1) {
            ret.append("7");
            n -= 3;
        }
        while (n > 0) {
            ret.append("1");
            n -= 2;
        }
        return ret.toString();
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        /*
        최대면 걍 1로 다채워넣고 7쓰면 됨 홀짝 나눠서
        최소면 dp로
         */


        int tc = Integer.parseInt(br.readLine());
        String[] dp = new String[101];
        Arrays.fill(dp, String.valueOf(Long.MAX_VALUE));

        dp[2] = "1";
        dp[3] = "7";
        dp[4] = "4";
        dp[5] = "2";
        dp[6] = "6";
        dp[7] = "8";

        String[] add = {"0", "0", "1", "7", "4", "2", "0", "8"};

        for (int i = 8; i <= 100; i++) {
            for (int j = 2; j <= 7; j++) {
                String curr = dp[i];
                String next = dp[i - j] + add[j];

                if (curr.length() > next.length()) {
                    dp[i] = next;
                } else if (curr.length() == next.length()) {
                    if (curr.compareTo(next) > 0) {
                        dp[i] = next;
                    }
                }
            }
        }

        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            String min = dp[n];
            String max = greedy(n);
            sb.append(min).append(" ").append(max).append("\n");
        }


        System.out.print(sb);
    }


}

