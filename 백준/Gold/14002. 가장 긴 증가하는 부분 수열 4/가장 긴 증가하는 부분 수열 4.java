import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        int[] prev = new int[n + 1];
        Arrays.fill(dp, 1);
        int max = 1;
        int argmax = 1;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 2 ; i <= n ; i++) {
            for(int j = 1 ; j <= i ; j++) {
                if(arr[i] > arr[j]) {
                    if(dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                    if(max < dp[i]) {
                        max = dp[i];
                        argmax = i;
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(dp));
//        System.out.println(Arrays.toString(prev));
        sb.append(max).append("\n");
        while(true) {
            stack.push(arr[argmax]);
            argmax = prev[argmax];
            if(argmax == 0) break;
        }
        while(!stack.isEmpty()) sb.append(stack.pop()).append(" ");
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}