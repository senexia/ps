import java.io.*;
import java.util.*;

public class Main {
    static int n, sqrt;
    static long[] arr;
    static long[] bucket;
    static StringBuilder sb = new StringBuilder();

    static void sum(int start, int end) {
        long res = 0;
        int s = start / sqrt;
        int e = end / sqrt;
        if(s == e) {
            for(int i = start ; i <= end ; i++) {
                res += arr[i];
            }
            sb.append(res).append("\n");
        } else {
            for(int i = start ; i < (s + 1) * sqrt ; i++) {
                res += arr[i];
            }
            for(int i = s + 1 ; i < e ; i++) {
                res += bucket[i];
            }
            for(int i = e * sqrt ; i <= end ; i++) {
                res += arr[i];
            }
            sb.append(res).append("\n");
        }
    }
    static void modify(int at, int val) {
        long old = arr[at];
        long diff = val - old;
        arr[at] = val;
        bucket[at / sqrt] += diff;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        sqrt = (int)Math.sqrt(n);

        arr = new long[n];
        bucket = new long[1 + (n-1)/sqrt];
        for(int i = 0 ; i < k ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == 0) {
                //sum
                sum(Math.min(b, c) - 1, Math.max(b, c) - 1);
            } else {
                //modify
                modify(b - 1, c);
            }
        }
        sb.setLength(sb.length() - 1);
        System.out.print(sb);
    }
}