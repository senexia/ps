import java.io.*;
import java.util.*;

public class Main {
    static long[] arr;
    static long[] bucket;
    static long[] lazy;
    static int sqrt;
    static int LAST_BLOCK_INDEX;
    static int LAST_BLOCK_SIZE;
    static StringBuilder sb = new StringBuilder();

    static void update(int start, int end, long val) {
        int s = start / sqrt;
        int e = end / sqrt;
        if(s == e) {
            for(int i = start ; i <= end ; i++) {
                arr[i] += val;
                bucket[s] += val;
            }
        } else {
            for(int i = start ; i < (s + 1) * sqrt ; i++) {
                arr[i] += val;
                bucket[s] += val;
            }
            for(int i = s + 1 ; i < e ; i++) {
                lazy[i] += val;
            }
            for(int i = e * sqrt ; i <= end ; i++) {
                arr[i] += val;
                bucket[e] += val;
            }
        }
    }


    static void cal(int start, int end) {
        int s = start / sqrt;
        int e = end / sqrt;
        long sum = 0;
        if(s == e) {
            for(int i = start ; i <= end ; i++) {
                sum += (arr[i] + lazy[s]);
            }
            sb.append(sum).append("\n");
        } else {
            for(int i = start ; i < (s + 1) * sqrt ; i++) {
                sum += (arr[i] + lazy[s]);
            }
            for(int i = s + 1 ; i < e ; i++) {
                if(i == LAST_BLOCK_INDEX) {
                    sum += bucket[i];
                    sum += (lazy[i] * LAST_BLOCK_SIZE);
                } else {
                    sum += bucket[i];
                    sum += (lazy[i] * sqrt);
                }
            }
            for(int i = e * sqrt ; i <= end ; i++) {
                sum += (arr[i] + lazy[e]);
            }
            sb.append(sum).append("\n");
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        sqrt = (int)Math.sqrt(n);
        LAST_BLOCK_INDEX = (n-1) / sqrt;
        LAST_BLOCK_SIZE = (n == sqrt * sqrt) ? sqrt : n - sqrt * sqrt;

        arr = new long[n];
        bucket = new long[1 + (n-1) / sqrt];
        lazy = new long[1 + (n-1) / sqrt];

        for(int i = 0 ; i < n ; i++) {
            arr[i] = Long.parseLong(br.readLine());
            bucket[i / sqrt] += arr[i];
        }

        for(int i = 0 ; i < m + k ; i++) {
            String s = br.readLine();
            if(s.charAt(0) == '1') {
                st = new StringTokenizer(s, " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                long d = Long.parseLong(st.nextToken());
                update(b, c, d);
            } else {
                st = new StringTokenizer(s, " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken()) - 1;
                cal(b, c);
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}