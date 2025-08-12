import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        if(arr[n - 1] < 0) {
            //전부 음수인 경우
            sb.append(arr[n - 2]).append(" ").append(arr[n - 1]);
            System.out.println(sb);
            return;
        }

        if(arr[0] > 0) {
            //전부 양수인 경우
            sb.append(arr[0]).append(" ").append(arr[1]);
            System.out.println(sb);
            return;
        }
        int s = 0, e = n - 1;
        int x1 = 0, x2 = 0;
        int sum = arr[s] + arr[e];
        int norm = Integer.MAX_VALUE;
        while(s < e) {
            sum = arr[s] + arr[e];
            if(norm > Math.abs(sum)) {
                norm = Math.abs(sum);
                x1 = s;
                x2 = e;
                if(sum == 0) break;
            }

            if(sum < 0) s++;
            if(sum > 0) e--;
        }
        sb.append(arr[x1]).append(" ").append(arr[x2]);
        System.out.println(sb);
    }
}