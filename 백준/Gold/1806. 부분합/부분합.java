import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());
        int len = Integer.MAX_VALUE;
        int[] arr = new int[n];
        int[] psum = new int[n + 1];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            psum[i + 1] = psum[i] + arr[i];
        }

        int s = 0;
        int e = 1;
        while(!(e == n + 1)) {
            int curr = psum[e] - psum[s];

            if(sum > curr) {
                e++;
            } else {
                if(len > e - s) len = e - s;
                s++;
            }
        }
        System.out.println(len == Integer.MAX_VALUE ? 0 : len);
    }
}