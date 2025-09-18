import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        if(n == 1) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int s = 0;
        int e = n - 1;
        int cnt = 0;
        while(s < e) {
            int sum = arr[s] + arr[e];
            if(m < sum) e--;
            else if(m > sum) s++;
            else {
                cnt++;
                s++;
                e--;
            }
        }
        System.out.println(cnt);
    }
}