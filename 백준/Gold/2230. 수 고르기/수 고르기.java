import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int res = Integer.MAX_VALUE;
        int s = 0;
        int e = 0;
        while(!(e == n)) {
            int diff = arr[e] - arr[s];
            if(diff < m) {
                e++;
            } else if(diff > m) {
                if(res > diff) res = diff;
                s++;
            } else {
                System.out.println(m);
                return;
            }
        }
        System.out.println(res);
    }
}