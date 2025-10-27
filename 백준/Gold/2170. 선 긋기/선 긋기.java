import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]
        );

        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.offer(new int[] {a, b});
        }

        int sum = 0;

        int[] t = pq.poll();
        int s = t[0];
        int e = t[1];

        for(int i = 1 ; i < n ; i++) {
            t = pq.poll();
            int a = t[0];
            int b = t[1];
            if(a <= e) {
                if(b > e) {
                    e = b;
                }
                // [1, 5]   ,   [2, 3] 이런식으로 들어올 수도 있기때문에
                // 무작정 첫값 포함된다고 끝값 갱신해버리면 안 됨

            } else {
                sum += e - s;
                s = a;
                e = b;
            }
        }
        sum += e - s;
        System.out.println(sum);
    }
}