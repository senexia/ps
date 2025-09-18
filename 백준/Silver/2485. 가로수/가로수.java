import java.io.*;
import java.util.*;

public class Main {
    static int gcd(int a, int b) {
        if(a == 0) return b;
        return gcd(b % a, a);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /*
        어떤 구간을 고정해놓고 생각해보면

        이 구간 사이에 가로수를 n개 심는 행위는 간격을 줄이는 행위
        (원래구간길이)/(n+1) 의 길이를 갖는 n+1개의 소구간이 생기니까

        1. 각 구간의 길이를 전부 구한다 a[0] ~ a[n]
        2. 모든 구간길이의 gcd를 구한다
        3. sum_i {(a[i]/gcd) - 1} 이 정답
         */
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dist = new int[n - 1];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0 ; i < n - 1 ; i++) {
            dist[i] = arr[i + 1] - arr[i];
        }
        int gcd = dist[0];
        for(int i = 1 ; i < n - 1 ; i++) {
            gcd = gcd(gcd, dist[i]);
        }
        int sum = 0;
        for(int i = 0 ; i < n - 1 ; i++) {
            sum += (dist[i] / gcd) - 1;
        }
        System.out.println(sum);
    }
}