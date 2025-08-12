import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[100001];
        int ways = 0;
        int bound = Integer.MAX_VALUE;

        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        if(s >= e) {
            //이미 같거나 뒤로만 가야하는 경우
            System.out.println(s - e);
            System.out.println(1);
            return;
        }

        q.offer(s);
        while(!q.isEmpty()) {
            int x = q.poll();

            //최단거리보다 길면 컷
            if(dist[x] > bound) continue;
            
            //목적지 도달
            if(x == e) {
                if(bound > dist[x]) {
                    //bound보다 거리가 짧은지 ? : 최초 1번만 걸릴 거임 -> 최단거리 파악용 + ways증가
                    bound = dist[x];
                    ways++;
                } else if(bound == dist[x]) {
                    //실질적으로 같은 거리인데 늦게 도착하는 애들은 여기에 걸림 -> ways증가
                    ways++;
                }
                continue;
            }
            if(x > 0 && 2 * x <= 100000) {
                if(dist[2 * x] == 0 || dist[2 * x] >= dist[x] + 1) {
                    q.offer(2 * x);
                    dist[2 * x] = dist[x] + 1;
                }
            }
            if(x + 1 <= 100000) {
                if(dist[x + 1] == 0 || dist[x + 1] >= dist[x] + 1) {
                    q.offer(x + 1);
                    dist[x + 1] = dist[x] + 1;
                }
            }
            if(x - 1 >= 0) {
                if(dist[x - 1] == 0 || dist[x - 1] >= dist[x] + 1) {
                    q.offer(x - 1);
                    dist[x - 1] = dist[x] + 1;
                }
            }
        }

        System.out.println(bound);
        System.out.println(ways);
    }
}