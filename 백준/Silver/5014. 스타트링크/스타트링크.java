import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayDeque<int[]> q = new ArrayDeque<>();

        int floors = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        //숨바꼭질 1이랑 비슷한 느낌으로 풀면 될듯.
        int[] dist = new int[floors + 1];
        dist[start] = 0;
        q.offer(new int[] {start, 0});
        while(!q.isEmpty()) {
            int[] temp = q.poll();
            int curr = temp[0];
            int depth = temp[1];
            if(curr == end) {
                System.out.println(dist[end]);
                return;
            }

            if(curr + u <= floors && dist[curr + u] == 0) {
                dist[curr + u] = depth + 1;
                q.offer(new int[] {curr + u, depth + 1});
            }
            if(curr - d >= 1 && dist[curr - d] == 0) {
                dist[curr - d] = depth + 1;
                q.offer(new int[] {curr - d, depth + 1});
            }
        }
        System.out.println("use the stairs");
    }
}