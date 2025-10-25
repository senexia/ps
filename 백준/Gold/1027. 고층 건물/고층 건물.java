import java.io.*;
import java.util.*;

public class Main {
    /*
    직선의 방정식을 통해 부등식을 세워보면
    dx * y > dy * (x - i) + dx * arr[i]

    마지막 테케 -> 항상 범위 주의

    전부 int안에 들어오더라도 곱하거나 더하면 long 써야할 수도 있음
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = -1;
        for(int i = 0 ; i < n ; i++) {
            int l = i - 1;
            int r = i + 1;
            int cnt = 0;

            while(l >= 0) {
                long dx = i - l;
                long dy = arr[i] - arr[l];
                boolean flag = true;
                for(int j = l + 1 ; j < i ; j++) {
                    if(dx * arr[j] >= dy * (j - i) + dx * arr[i]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) cnt++;
                l--;
            }
            while(r < n) {
                long dx = r - i;
                long dy = arr[r] - arr[i];
                boolean flag = true;
                for(int j = i + 1 ; j < r ; j++) {
                    if(dx * arr[j] >= dy * (j - i) + dx * arr[i]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) cnt++;
                r++;
            }
            if(max < cnt) max = cnt;
        }
        System.out.println(max);
    }
}