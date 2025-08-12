import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[100001];

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int step = 0;

        if(s >= e) {
            //이미 같거나 뒤로만 가야하는 경우
            System.out.println(s - e);
            return;
        }

        q.offer(s);
        while(!q.isEmpty()) {
            int x = q.poll();
            if(x == e) break;
            if(x > 0 && 2 * x <= 100000 && dist[2 * x] == 0) {
                q.offer(2 * x);
                dist[2 * x] = dist[x] + 1;
            }
            if(x + 1 <= 100000 && dist[x + 1] == 0) {
                q.offer(x + 1);
                dist[x + 1] = dist[x] + 1;
            }
            if(x - 1 >= 0 && dist[x - 1] == 0) {
                q.offer(x - 1);
                dist[x - 1] = dist[x] + 1;
            }
        }

        System.out.println(dist[e]);
    }
}