import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = -1;
        int cnt = 0;
        int sum = 0;

        int s = 0;
        int e = s + m - 1;
        for(int i = s ; i <= e ; i++) {
            sum += arr[i];
        }

        if(max < sum) {
            max = sum;
            cnt = 1;
        } else if(max == sum) {
            cnt++;
        }

        while(e < n - 1) {
            sum -= arr[s++];
            e++;
            sum += arr[e];
            if(max < sum) {
                max = sum;
                cnt = 1;
            } else if(max == sum) {
                cnt++;
            }
        }
        if(max == 0) {
            System.out.println("SAD");
            return;
        }
        sb.append(max).append("\n").append(cnt);
        System.out.print(sb);
    }
}