import java.io.*;
import java.util.*;

public class Main {
    static int pos(int x, int y) {
        return (x + y) > 0 ? x + y : -(x + y);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = n - 1;

        if(arr[s] >= 0) {
            //음수 없음
            System.out.println(arr[s] + arr[s+1]);
            return;
        } else if(arr[e] <= 0) {
            //양수 없음
            System.out.println(arr[e] + arr[e-1]);
            return;
        } else {
            int ans = pos(arr[s], arr[e]);
            int sum = arr[s] + arr[e];
            while(s < e) {
                int curr = pos(arr[s], arr[e]);
                int tempsum = arr[s] + arr[e];
                if(ans > curr) {
                    ans = curr;
                    sum = tempsum;
                }

                if(tempsum < 0) s++;
                else if(tempsum > 0) e--;
                else {
                    System.out.println(0);
                    return;
                }
            }
            System.out.println(sum);

        }

    }
}