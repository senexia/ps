import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayDeque<Integer> q = new ArrayDeque<>();

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int[] dist = new int[100001];
        boolean[] v = new boolean[100001];

        if(s >= e) {
            System.out.println(s - e);
            return;
        }

        q.addFirst(s);
        v[s] = true;
        while(!q.isEmpty()) {
            int x = q.pop();
            if(x == e) {
                System.out.println(dist[e]);
                return;
            }
            if(x > 0 && 2 * x <= 100000 && !v[2 * x]) {
                q.addFirst(2 * x);
                v[2 * x] = true;
                dist[2 * x] = dist[x];
            }
            if(x - 1 >= 0 && !v[x - 1]) {
                q.addLast(x - 1);
                v[x - 1] = true;
                dist[x - 1] = dist[x] + 1;
            }
            if(x + 1 <= 100000 && !v[x + 1]) {
                q.addLast(x + 1);
                v[x + 1] = true;
                dist[x + 1] = dist[x] + 1;
            }
        }
    }
}