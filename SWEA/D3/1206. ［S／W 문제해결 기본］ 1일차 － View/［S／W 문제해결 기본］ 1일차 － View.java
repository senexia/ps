import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int tc = 0 ; tc < 10 ; tc++) {
            int n = Integer.parseInt(br.readLine());
            int jm = 0;
            sb.append("#").append(tc+1).append(" ");

            int[] bds = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i < n ; i++) {
                bds[i] = Integer.parseInt(st.nextToken());
            }


            for(int i = 2 ; i <= n - 3 ; i++) {
                int le = Math.max(bds[i-1], bds[i-2]);
                int ri = Math.max(bds[i+1], bds[i+2]);
                if(bds[i] < le || bds[i] < ri) continue;

                int temp = bds[i] - Math.max(le, ri);
                jm += temp;
            }
            sb.append(jm).append("\n");
        }
        sb.setLength(sb.length() - 1);
        System.out.println(sb);
    }
}