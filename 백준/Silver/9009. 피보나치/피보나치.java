import java.io.*;
import java.util.*;

public class Main {
    /*
    일반항 생각하면. f_n ~ 2^(n/2)정도.

    그러면 2^(n/2) = 10^9 에서 n = 18 * log_2 10 < 18 * log_2 16 = 18 * 4 = 72

    그리디하게 현재 수 이하인 가장 큰 피보나치수를 계속 계산해주고, 그 값을 현재값에서 빼면서 갱신해주면 됨.

    점화식의 특성상 가장 큰 피보나치 수를 쓰는게 아니라면 2개 이상의 다른 피보나치 수의 합으로 동일하게 표현가능하므로
    이는 곧 개수가 최소가 되는 것과 멀어지게 됨

    따라서 항상 그리디하게 현재 수 이하인 가장 큰 피보나치수를 택하면 됨
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        TreeSet<Integer> ts = new TreeSet<>();
        ArrayDeque<Integer> s = new ArrayDeque<>();

        int[] dp = new int[75];
        dp[1] = 1;
        dp[2] = 1;
        ts.add(1);
        for(int i = 3 ; i < 75 ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            if(dp[i] >= 1000000000 || dp[i] <= 0) break;
            ts.add(dp[i]);
        }
//        System.out.println(ts.floor(8));
//        for(int a : dp) System.out.println(a);

        int tc = Integer.parseInt(br.readLine());
        for(int t = 1 ; t <= tc ; t++) {
            int curr = Integer.parseInt(br.readLine());
            while(curr > 0) {
                int floor = ts.floor(curr);
                s.push(floor);
                curr -= floor;
            }
            while(!s.isEmpty()) {
                sb.append(s.pop()).append(" ");
            }
            sb.setLength(sb.length() - 1);
            sb.append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}