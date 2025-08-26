import java.io.*;
import java.util.*;

public class Solution {
    static int[] arr;
    static int[] op;

    static int max;
    static int min;
    static int n;

    static void dfs(int cnt, int curr) {
        if(cnt == n) {
            if(max < curr) max = curr;
            if(min > curr) min = curr;
            return;
        }
        for(int i = 0 ; i < 4 ; i++) {
            if(op[i] == 0) continue;
            op[i]--;

            if(i == 0) {
                dfs(cnt + 1, curr + arr[cnt]);
            } else if(i == 1) {
                dfs(cnt + 1, curr - arr[cnt]);
            } else if(i == 2) {
                dfs(cnt + 1, curr * arr[cnt]);
            } else {
                dfs(cnt + 1, (int) curr / arr[cnt]);
            }
            op[i]++;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for(int t = 1 ; t <= tc ; t++) {
            sb.append("#").append(t).append(" ");

            n = Integer.parseInt(br.readLine());
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            arr = new int[n];
            op = new int[4];

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i < 4;  i++) {
                op[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i < n ; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dfs(1, arr[0]);
            sb.append(max - min).append("\n");
//            System.out.println(max);
//            System.out.println(min);
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}