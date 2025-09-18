import java.io.*;
import java.util.*;

public class Main {
    static int max = 0;
    static int n;
    static int[] time;
    static int[] val;

    static void economicfreedom(int day, int sum) {
        if(day >= n) {
            if(day == n && time[n] == 1) {
                if(max < sum + val[n]) max = sum + val[n];
            } else {
                if(max < sum) max = sum;
            }
            return;
        }

        for(int i = day ; i <= n ; i++) {
            if(i + time[i] <= n + 1) economicfreedom(i + time[i], sum + val[i]);
        }
        //이 지점에서 더이상 받을 수 있는 상담이 없을 수도 있으므로 max 갱신시도
        if(max < sum) max = sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        /*
        k일에 기간이 T_k인 상담을 받으면, 다음에는 k + T_k일부터 확인하면 된다.
        종료조건은 k + T_k > N이다.

        예를 들어서 N = 7이고 6일차에 기간이 2인 상담을 받을 수 있다.
        그러면 6 + 2 = 8 > N이므로 종료. 이때 k + T_k <= N + 1인거까지는 괜찮다.

        강의실 배정문제 같은건가 아니면 N이 작아서 그냥 다해봐도 될거같은데
        백트래킹 느낌으로
         */

        n = Integer.parseInt(br.readLine());
        time = new int[n + 1];
        val = new int[n + 1];

        for(int i = 1 ; i < n + 1 ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            val[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1 ; i <= n ; i++) {
            if(i + time[i] <= n + 1) economicfreedom(i, 0);
        }
        System.out.println(max);
    }
}