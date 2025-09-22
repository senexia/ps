import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        boolean[] p = new boolean[n + 1];
        Arrays.fill(p, true);
//        p[2] = true;
//        p[3] = true;
        p[0] = false;
        p[1] = false;
        for(int i = 2 ; i * i <= n ; i++) {
            if(p[i]) {
                for(int j = 2 ; i * j <= n ; j++) {
                    p[i * j] = false;
                }
            }
        }
        int cnt = 0;
        for(int i = 1 ; i < n + 1 ; i++) {
            if(p[i]) cnt++;
        }
        //여기까지 소수 전처리

        //구해둔 소수 배열에 담기
        int[] primes = new int[cnt];
        int[] psum = new int[cnt + 1];
        int ptr = 0;
        for(int i = 2 ; i < n + 1 ; i++) {
            if(p[i]) {
                primes[ptr++] = i;
                psum[ptr] = psum[ptr - 1] + primes[ptr - 1];
                //ptr++로 하나 더해졌을거니까 primes[ptr]이 아니라 primes[ptr - 1]
            }
        }
//        System.out.println(Arrays.toString(primes));
//        System.out.println(Arrays.toString(psum));

        int sum = 0;
        int s = 0;
        int e = 1;
        int ans = 0;
        while(e < cnt + 1) {
            sum = psum[e] - psum[s];
            if(sum == n) {
                ans++;
                s++;
            } else if(sum > n) s++;
            else e++;
        }
        System.out.println(ans);
    }
}